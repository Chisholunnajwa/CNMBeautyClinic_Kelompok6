package com.example.cnmbeautyclinickelompok_6.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.cnmbeautyclinickelompok_6.model.Treatment

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "clinic.db", null, 2) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL(
            """
            CREATE TABLE treatment(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nama TEXT,
                harga TEXT,
                deskripsi TEXT,
                manfaat TEXT
            )
            """.trimIndent()
        )

        // DATA AWAL PRICELIST

        insertTreatment(
            db,
            "Facial Basic",
            "Rp 75.000",
            "Perawatan wajah dasar",
            "Membersihkan wajah"
        )

        insertTreatment(
            db,
            "Facial Lux",
            "Rp 115.000",
            "Facial premium",
            "Kulit lebih sehat"
        )

        insertTreatment(
            db,
            "Signature Facial",
            "Rp 175.000",
            "Perawatan facial signature",
            "Kulit glowing"
        )

        insertTreatment(
            db,
            "Facial Oxygeneo Neocell",
            "Rp 375.000",
            "Perawatan oxygeneo",
            "Mencerahkan wajah"
        )

        insertTreatment(
            db,
            "Light Chemical Peeling",
            "Rp 195.000",
            "Chemical peeling ringan",
            "Mengangkat sel kulit mati"
        )

        insertTreatment(
            db,
            "Advance Chemical Peeling",
            "Rp 250.000",
            "Chemical peeling lanjutan",
            "Kulit lebih cerah"
        )

        insertTreatment(
            db,
            "Premium Chemical Peeling",
            "Rp 450.000",
            "Chemical peeling premium",
            "Membantu regenerasi kulit"
        )

        insertTreatment(
            db,
            "Mesotherapy No Needle",
            "Rp 175.000",
            "Mesotherapy tanpa jarum",
            "Mengencangkan kulit"
        )

        insertTreatment(
            db,
            "Acne Clear Booster",
            "Rp 550.000",
            "Perawatan jerawat",
            "Mengurangi jerawat"
        )

        insertTreatment(
            db,
            "Flek Injection",
            "Rp 550.000",
            "Injection flek wajah",
            "Mengurangi flek hitam"
        )

        insertTreatment(
            db,
            "Colagen Stimulator",
            "Rp 1.500.000",
            "Stimulator collagen",
            "Kulit lebih kencang"
        )

        insertTreatment(
            db,
            "Skin Booster",
            "Rp 750.000",
            "Booster kulit",
            "Melembapkan kulit"
        )

        insertTreatment(
            db,
            "Fat Free Injection",
            "Rp 200.000/cc",
            "Penghancur lemak",
            "Mengurangi lemak"
        )

        insertTreatment(
            db,
            "RF-Cavitasi",
            "Rp 75.000",
            "RF Cavitasi",
            "Membentuk tubuh"
        )

        insertTreatment(
            db,
            "HIFU",
            "Rp 250.000",
            "High Intensity Focused Ultrasound",
            "Mengencangkan wajah"
        )

        insertTreatment(
            db,
            "Dermalux IPL",
            "Rp 250.000",
            "IPL treatment",
            "Mencerahkan kulit"
        )

        insertTreatment(
            db,
            "Laser Ndyag",
            "Rp 250.000",
            "Laser wajah",
            "Mengurangi noda"
        )

        insertTreatment(
            db,
            "Laser Rebeam",
            "Rp 250.000",
            "Laser rebeam",
            "Kulit lebih sehat"
        )

        insertTreatment(
            db,
            "Laser Fractional Co2",
            "Rp 1.500.000",
            "Laser fractional",
            "Memperbaiki tekstur kulit"
        )

        insertTreatment(
            db,
            "Electrocauter",
            "Rp 200.000",
            "Electrocauter treatment",
            "Menghilangkan skin tag"
        )

        insertTreatment(
            db,
            "Fat Freezing & Lipo Laser",
            "Rp 550.000",
            "Perawatan tubuh",
            "Mengurangi lemak tubuh"
        )

        insertTreatment(
            db,
            "PRP",
            "Rp 450.000",
            "Platelet Rich Plasma",
            "Regenerasi kulit"
        )

        insertTreatment(
            db,
            "Dermaglow",
            "Rp 650.000",
            "Dermaglow facial",
            "Kulit glowing"
        )

        insertTreatment(
            db,
            "Injeksi Acne",
            "Rp 35.000",
            "Injeksi jerawat",
            "Mengurangi peradangan"
        )

        insertTreatment(
            db,
            "Injeksi VIT C",
            "Rp 125.000",
            "Vitamin C injection",
            "Mencerahkan kulit"
        )
    }

    private fun insertTreatment(
        db: SQLiteDatabase,
        nama: String,
        harga: String,
        deskripsi: String,
        manfaat: String
    ) {

        val values = ContentValues().apply {

            put("nama", nama)
            put("harga", harga)
            put("deskripsi", deskripsi)
            put("manfaat", manfaat)
        }

        db.insert("treatment", null, values)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {

        db.execSQL("DROP TABLE IF EXISTS treatment")

        onCreate(db)
    }

    // CREATE
    fun insert(
        nama: String,
        harga: String,
        deskripsi: String,
        manfaat: String
    ) {

        val db = writableDatabase

        val values = ContentValues().apply {

            put("nama", nama)
            put("harga", harga)
            put("deskripsi", deskripsi)
            put("manfaat", manfaat)
        }

        db.insert(
            "treatment",
            null,
            values
        )
    }

    // READ
    fun getAll(): List<Treatment> {

        val list = mutableListOf<Treatment>()

        val db = readableDatabase

        val cursor =
            db.rawQuery(
                "SELECT * FROM treatment",
                null
            )

        while (cursor.moveToNext()) {

            list.add(
                Treatment(
                    id = cursor.getInt(0),
                    nama = cursor.getString(1),
                    harga = cursor.getString(2),
                    deskripsi = cursor.getString(3),
                    manfaat = cursor.getString(4)
                )
            )
        }

        cursor.close()

        return list
    }

    // UPDATE
    fun update(
        id: Int,
        nama: String,
        harga: String,
        deskripsi: String,
        manfaat: String
    ) {

        val db = writableDatabase

        val values = ContentValues().apply {

            put("nama", nama)
            put("harga", harga)
            put("deskripsi", deskripsi)
            put("manfaat", manfaat)
        }

        db.update(
            "treatment",
            values,
            "id=?",
            arrayOf(id.toString())
        )
    }

    // DELETE
    fun delete(id: Int) {

        val db = writableDatabase

        db.delete(
            "treatment",
            "id=?",
            arrayOf(id.toString())
        )
    }
}