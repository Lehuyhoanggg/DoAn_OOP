# Copilot instructions for DoAn_OOP

This repository contains a small Java OOP student project (sales management + some demo programs). The guidance below highlights the project's structure, conventions and actionable patterns an AI coding assistant should follow to be productive.

1. Big-picture architecture
   - Project is plain Java source files (no build tool). Source root: repository root `DoAn_OOP/`.
   - Main entrypoints / demos:
     - `Main.java` — contains a console Minesweeper demo (self-contained). Use it as a runnable example.
     - Other classes under `DoAn_OOP/` and subfolders implement an OOP sales manager application (models, services, repositories, UI).
   - Key directories:
     - `model/` — domain objects (e.g. `SanPham.java`, `NhanVien.java`, `HoaDon.java`). Prefer getters/setters conventions already present.
     - `service/` — business logic stubs (some files empty). Implement behavior here when adding features.
     - `repository/` — file IO helpers (`DocFile.java`, `GhiFile.java`) — currently placeholders.
     - `giaodien/` — simple console UI screens (`Nhap.java`, `Xuat.java`) that orchestrate reading/writing models.
     - `util/` — small helpers (`TaoDoiTuong.java`, `ThoiGian.java`).

2. Project conventions and patterns
   - Package declarations: most classes include `package` lines under their folder (e.g. `package model;`). Keep package -> folder mapping consistent.
   - Plain Java (no Maven/Gradle). Compilation/run is via `javac`/`java` from the repository folder. Examples:
     - Compile all: `javac DoAn_OOP/*.java DoAn_OOP/*/*.java` from `c:\java`
     - Run a main class: `java -cp . DoAn_OOP.Main` or `java -cp DoAn_OOP Main` depending on current directory — prefer running from `DoAn_OOP` folder: `javac *.java */*.java` then `java Main`.
   - Null / empty implementations: Several service and repository files are empty (placeholders). New logic should be added to `service/` and `repository/` and referenced from `giaodien/` UI.
   - Strings & messages: UI text is Vietnamese. Preserve message style and prompts when adding UI changes.

3. How data flows
   - UI (`giaodien`) reads input -> constructs `model` objects (via `util/TaoDoiTuong` or direct constructors) -> passes to `service` for business rules -> `repository` persists via file helpers.
   - Look for `TinNhan`, `HoaDon`, `SanPham` as common model types to connect features.

4. Editing rules for AI agents
   - Small, incremental edits: prefer adding methods in `service/` and `repository/` rather than moving packages.
   - Keep package declarations and public API stable; add new public methods rather than renaming existing ones.
   - When creating new files, follow existing package naming (e.g., `package service;`) and place under the corresponding folder.
   - For UI changes, keep Vietnamese prompts and existing Console-style I/O.

5. Build / run / debug commands (Windows PowerShell)
   - From workspace root (`c:\java`), compile the project under `DoAn_OOP` and run `Main`:
     ```powershell
     cd c:\java\DoAn_OOP
     javac *.java */*.java
     java Main
     ```
   - To compile a single package (e.g. models): `javac model\*.java` then run a main class that depends on them.

6. Examples & file pointers
   - Use `model/SanPham.java` as canonical POJO pattern (private fields + getters/setters + small helper `getTrangThai()` returning Vietnamese status strings).
   - `util/TaoDoiTuong.java` shows factory-like helpers that return model objects (e.g., `taoTinNhan()`).
   - `Main.java` demonstrates CLI loop patterns and defensive input parsing — follow its parsing/printing style for new CLI code.

7. Limits & assumptions discovered
   - No automated tests or CI configuration present.
   - No external libraries — stick to Java standard library.
   - The codebase mixes multiple demo programs in one folder (e.g., Minesweeper inside `Main.java`) — be careful when modifying `Main.java`.

If any part of the project requires deeper domain knowledge (business rules for invoices, discounts, or file formats), ask for sample files or expected format before adding persistence logic. Would you like me to (A) create a minimal compile/run script in `README.md`, or (B) try to implement a simple `repository/GhiFile`/`DocFile` pair to persist `SanPham` as CSV? Reply with your preference.
