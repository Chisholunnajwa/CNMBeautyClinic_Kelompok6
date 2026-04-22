package com.example.cnmbeautyclinic.data

data class Treatment(
    val nama: String,
    val harga: String
)

data class Category(
    val title: String,
    val items: List<Treatment>
)

val treatmentCategories = listOf(

    // BEAUTY TREATMENTS
    Category(
        "BEAUTY TREATMENTS",
        listOf(
            Treatment("Facial Basic", "Rp 75.000"),
            Treatment("Facial Lux", "Rp 115.000"),
            Treatment("Signature Facial", "Rp 175.000"),
            Treatment("Facial Oxygeneo Neocell", "Rp 375.000"),
            Treatment("Light Chemical Peeling", "Rp 195.000"),
            Treatment("Advance Chemical Peeling", "Rp 250.000"),
            Treatment("Premium Chemical Peeling", "Rp 450.000"),
            Treatment("Mesotherapy No Needle (Whitening, Open Pore, Anti Aging)", "Rp 175.000"),
            Treatment("Acne Clear Booster", "Rp 550.000"),
            Treatment("Flek Injection", "Rp 550.000"),
            Treatment("Colagen Stimulator", "Start From Rp 1.500.000"),
            Treatment("Skin Booster", "Start From Rp 750.000"),
            Treatment("Fat Free Injection", "Rp 200.000/cc"),
            Treatment("RF-Cavitasi", "Start From Rp 75.000"),
            Treatment("HIFU", "Start From Rp 250.000"),
            Treatment("Dermalux IPL", "Start From Rp 250.000"),
            Treatment("Laser Ndyag", "Start From Rp 250.000"),
            Treatment("Laser Rebeam", "Start From Rp 250.000"),
            Treatment("Laser Fractional Co2", "Rp 1.500.000"),
            Treatment("Electrocauter", "Start From Rp 200.000"),
            Treatment("Fat Freezing & Lipo Laser", "Start From Rp 550.000"),
            Treatment("PRP", "Rp 450.000"),
            Treatment("Dermaglow", "Rp 650.000"),
            Treatment("Injeksi Acne", "Start From Rp 35.000"),
            Treatment("Injeksi VIT C", "Rp 125.000")
        )
    ),

    // INFUS
    Category(
        "INFUS",
        listOf(
            Treatment("Skin Refresher", "Rp 550.000"),
            Treatment("Bright Skin", "Rp 750.000"),
            Treatment("Diamond Whitening", "Rp 950.000"),
            Treatment("PDT + Mask", "Rp 50.000")
        )
    ),

    // CONTOURING
    Category(
        "CONTOURING",
        listOf(
            Treatment("Botox Korea 50U", "Rp 1.500.000"),
            Treatment("Botox Lanzox 50U", "Rp 2.999.000"),
            Treatment("Filler Dagu Korea", "Start From Rp 1.500.000"),
            Treatment("Korea Nose Threadlift", "Rp 550.000/benang"),
            Treatment("Face Lift", "Rp 950.000/benang")
        )
    )
)