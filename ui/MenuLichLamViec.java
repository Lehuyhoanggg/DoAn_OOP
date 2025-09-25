package ui;

import database.Database;
import model.LichLamViec;
import service.LichLamViecService;

public class MenuLichLamViec {
    private Database db;

    public MenuLichLamViec(Database db) {
        this.db = db;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }
}
