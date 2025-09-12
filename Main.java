import java.util.*;

/**
 * Minesweeper console game
 * - Chạy: javac Minesweeper.java && java Minesweeper
 * - Lệnh:
 * o r c -> open (mở) ô hàng r c (1-based)
 * f r c -> flag (đặt/ bỏ cờ) ô hàng r c
 * q -> quit
 *
 * Giao diện đơn giản: hiển thị chỉ số hàng/cột, ? = chưa mở, F = cờ, số = số
 * mìn xung quanh, . = ô mở có 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Minesweeper (Console) ===");
        System.out.print("Chiều cao (hàng) [ví dụ 9]: ");
        int rows = parseIntOrDefault(sc.nextLine(), 9);
        System.out.print("Chiều rộng (cột) [ví dụ 9]: ");
        int cols = parseIntOrDefault(sc.nextLine(), 9);
        System.out.print("Số mìn [ví dụ 10]: ");
        int bombs = parseIntOrDefault(sc.nextLine(), Math.max(10, (rows * cols) / 6));
        if (bombs >= rows * cols)
            bombs = rows * cols - 1;

        Board board = new Board(rows, cols, bombs);
        boolean lost = false;

        while (true) {
            board.printVisible();
            if (board.isWin()) {
                System.out.println("Chúc mừng! Bạn đã thắng!");
                board.revealAll();
                board.printVisible();
                break;
            }
            System.out.print("Nhập lệnh (o r c, f r c, q): ");
            String line = sc.nextLine().trim();
            if (line.isEmpty())
                continue;
            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase();

            if (cmd.equals("q")) {
                System.out.println("Thoát game. Bye!");
                break;
            } else if ((cmd.equals("o") || cmd.equals("open")) && parts.length >= 3) {
                int r = parseIntOrDefault(parts[1], -1);
                int c = parseIntOrDefault(parts[2], -1);
                if (!board.inBounds(r - 1, c - 1)) {
                    System.out.println("Toạ độ không hợp lệ.");
                    continue;
                }
                if (!board.started())
                    board.start(r - 1, c - 1); // ensure first move safe
                if (board.open(r - 1, c - 1)) {
                    // opened successfully, check if hit bomb
                    if (board.isBombAt(r - 1, c - 1)) {
                        board.revealAll();
                        board.printVisible();
                        System.out.println("Boom! Bạn đã dẫm mìn. GAME OVER.");
                        lost = true;
                        break;
                    }
                }
            } else if ((cmd.equals("f") || cmd.equals("flag")) && parts.length >= 3) {
                int r = parseIntOrDefault(parts[1], -1);
                int c = parseIntOrDefault(parts[2], -1);
                if (!board.inBounds(r - 1, c - 1)) {
                    System.out.println("Toạ độ không hợp lệ.");
                    continue;
                }
                board.toggleFlag(r - 1, c - 1);
            } else {
                System.out.println("Lệnh không hợp lệ.");
            }
        }

        if (lost) {
            System.out.println("Bạn có muốn chơi lại? (y/n): ");
            String a = sc.nextLine().trim().toLowerCase();
            if (a.equals("y")) {
                main(args);
            }
        }

        sc.close();
    }

    private static int parseIntOrDefault(String s, int def) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return def;
        }
    }
}

class Board {
    private final int rows, cols, bombs;
    private final Cell[][] grid;
    private boolean started = false;
    private int openedCount = 0;
    private int flagsUsed = 0;

    public Board(int rows, int cols, int bombs) {
        this.rows = rows;
        this.cols = cols;
        this.bombs = bombs;
        this.grid = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Cell();
            }
        }
    }

    public boolean started() {
        return started;
    }

    // Place bombs after first click to ensure first click never a bomb
    public void start(int safeR, int safeC) {
        started = true;
        Random rng = new Random();
        int placed = 0;
        while (placed < bombs) {
            int r = rng.nextInt(rows);
            int c = rng.nextInt(cols);
            if ((r == safeR && c == safeC) || grid[r][c].isBomb())
                continue;
            grid[r][c].setBomb(true);
            placed++;
        }
        // compute numbers
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!grid[r][c].isBomb()) {
                    grid[r][c].setAdj(countAdjacentBombs(r, c));
                }
            }
        }
    }

    private int countAdjacentBombs(int r, int c) {
        int cnt = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0)
                    continue;
                int nr = r + dr, nc = c + dc;
                if (inBounds(nr, nc) && grid[nr][nc].isBomb())
                    cnt++;
            }
        }
        return cnt;
    }

    public boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public boolean isBombAt(int r, int c) {
        if (!inBounds(r, c))
            return false;
        return grid[r][c].isBomb();
    }

    // open cell; returns true if action performed
    public boolean open(int r, int c) {
        if (!inBounds(r, c))
            return false;
        Cell cell = grid[r][c];
        if (cell.isRevealed() || cell.isFlagged())
            return false;
        revealCell(r, c);
        return true;
    }

    private void revealCell(int r, int c) {
        Cell cell = grid[r][c];
        if (cell.isRevealed() || cell.isFlagged())
            return;
        cell.setRevealed(true);
        openedCount++;
        // if bomb, we stop (game will detect)
        if (cell.isBomb())
            return;
        if (cell.getAdj() == 0) {
            // flood fill neighbors
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0)
                        continue;
                    int nr = r + dr, nc = c + dc;
                    if (inBounds(nr, nc) && !grid[nr][nc].isRevealed()) {
                        revealCell(nr, nc);
                    }
                }
            }
        }
    }

    public void toggleFlag(int r, int c) {
        if (!inBounds(r, c))
            return;
        Cell cell = grid[r][c];
        if (cell.isRevealed()) {
            System.out.println("Ô này đã mở, không thể đặt cờ.");
            return;
        }
        if (cell.isFlagged()) {
            cell.setFlagged(false);
            flagsUsed--;
        } else {
            if (flagsUsed >= bombs) {
                System.out.println("Đã dùng hết số cờ bằng số mìn (" + bombs + ").");
                // vẫn cho phép đặt nếu muốn, nhưng logic này giới hạn flags
                // return;
            }
            cell.setFlagged(true);
            flagsUsed++;
        }
    }

    public boolean isWin() {
        // win khi mọi ô không phải bomb đều được mở
        int total = rows * cols;
        return (total - openedCount) == bombs;
    }

    public void revealAll() {
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c].setRevealed(true);
    }

    public void printVisible() {
        System.out.println();
        System.out.println(
                "Mìn: " + bombs + " | Cờ: " + flagsUsed + " | Mở: " + openedCount + "/" + (rows * cols - bombs));
        // header cols
        System.out.print("    ");
        for (int c = 1; c <= cols; c++) {
            System.out.printf("%3d", c);
        }
        System.out.println();
        System.out.print("    ");
        for (int c = 0; c < cols; c++) {
            System.out.print("---");
        }
        System.out.println();
        for (int r = 0; r < rows; r++) {
            System.out.printf("%3d|", r + 1);
            for (int c = 0; c < cols; c++) {
                Cell cell = grid[r][c];
                String out;
                if (!cell.isRevealed()) {
                    if (cell.isFlagged())
                        out = " F";
                    else
                        out = " ?";
                } else {
                    if (cell.isBomb())
                        out = " *";
                    else if (cell.getAdj() == 0)
                        out = " .";
                    else
                        out = String.format("%2d", cell.getAdj());
                }
                System.out.print(out);
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Cell {
    private boolean bomb = false;
    private boolean revealed = false;
    private boolean flagged = false;
    private int adj = 0;

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean b) {
        bomb = b;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean r) {
        revealed = r;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean f) {
        flagged = f;
    }

    public int getAdj() {
        return adj;
    }

    public void setAdj(int a) {
        adj = a;
    }
}
