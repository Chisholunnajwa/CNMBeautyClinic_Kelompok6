package com.example.cnmbeautyclinickelompok_6.data
data class Treatment(
    val nama: String,
    val harga: String,
    val deskripsi: String,
    val manfaat: String
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

            Treatment(
                "Facial Basic",
                "Rp 75.000",
                "Perawatan wajah dasar untuk membersihkan kulit dari debu dan minyak.",
                "Membantu wajah lebih bersih, segar, dan sehat."
            ),

            Treatment(
                "Facial Lux",
                "Rp 115.000",
                "Facial premium dengan perawatan kulit lebih mendalam.",
                "Membantu kulit lebih cerah dan rileks."
            ),

            Treatment(
                "Signature Facial",
                "Rp 175.000",
                "Perawatan wajah khusus dengan teknik facial modern.",
                "Membantu menjaga kelembapan dan kesehatan kulit."
            ),

            Treatment(
                "Facial Oxygeneo Neocell",
                "Rp 375.000",
                "Facial dengan teknologi oksigen untuk regenerasi kulit.",
                "Membantu kulit tampak glowing dan segar."
            ),

            Treatment(
                "Light Chemical Peeling",
                "Rp 195.000",
                "Chemical peeling ringan untuk mengangkat sel kulit mati.",
                "Membantu mencerahkan kulit wajah."
            ),

            Treatment(
                "Advance Chemical Peeling",
                "Rp 250.000",
                "Peeling tingkat lanjut untuk perawatan kulit kusam.",
                "Membantu menyamarkan noda dan jerawat."
            ),

            Treatment(
                "Premium Chemical Peeling",
                "Rp 450.000",
                "Perawatan peeling premium dengan hasil maksimal.",
                "Kulit menjadi lebih halus dan bersih."
            ),

            Treatment(
                "Mesotherapy No Needle",
                "Rp 175.000",
                "Perawatan tanpa jarum untuk whitening dan anti aging.",
                "Membantu kulit lebih cerah dan kenyal."
            ),

            Treatment(
                "Acne Clear Booster",
                "Rp 550.000",
                "Treatment khusus kulit berjerawat.",
                "Membantu mengurangi jerawat dan minyak berlebih."
            ),

            Treatment(
                "Flek Injection",
                "Rp 550.000",
                "Perawatan injeksi untuk mengurangi flek hitam.",
                "Membantu menyamarkan noda pada wajah."
            ),

            Treatment(
                "Colagen Stimulator",
                "Start From Rp 1.500.000",
                "Treatment untuk merangsang produksi kolagen.",
                "Membantu kulit lebih kencang dan awet muda."
            ),

            Treatment(
                "Skin Booster",
                "Start From Rp 750.000",
                "Perawatan untuk meningkatkan hidrasi kulit.",
                "Kulit menjadi lebih glowing dan sehat."
            ),

            Treatment(
                "Fat Free Injection",
                "Rp 200.000/cc",
                "Injeksi penghancur lemak pada area tertentu.",
                "Membantu membentuk tubuh lebih ideal."
            ),

            Treatment(
                "RF-Cavitasi",
                "Start From Rp 75.000",
                "Perawatan pembakaran lemak menggunakan teknologi RF.",
                "Membantu mengencangkan kulit tubuh."
            ),

            Treatment(
                "HIFU",
                "Start From Rp 250.000",
                "Treatment lifting wajah tanpa operasi.",
                "Membantu wajah lebih kencang."
            ),

            Treatment(
                "Dermalux IPL",
                "Start From Rp 250.000",
                "Perawatan IPL untuk kulit kusam dan flek.",
                "Membantu kulit lebih cerah."
            ),

            Treatment(
                "Laser Ndyag",
                "Start From Rp 250.000",
                "Laser treatment untuk flek dan pigmentasi.",
                "Membantu meratakan warna kulit."
            ),

            Treatment(
                "Laser Rebeam",
                "Start From Rp 250.000",
                "Laser khusus perawatan kulit sensitif.",
                "Membantu mengurangi kemerahan."
            ),

            Treatment(
                "Laser Fractional Co2",
                "Rp 1.500.000",
                "Laser untuk bekas jerawat dan peremajaan kulit.",
                "Membantu kulit lebih halus."
            ),

            Treatment(
                "Electrocauter",
                "Start From Rp 200.000",
                "Tindakan pengangkatan kutil atau skin tag.",
                "Membantu membersihkan gangguan pada kulit."
            ),

            Treatment(
                "Fat Freezing & Lipo Laser",
                "Start From Rp 550.000",
                "Perawatan penghancur lemak modern.",
                "Membantu membentuk tubuh lebih ideal."
            ),

            Treatment(
                "PRP",
                "Rp 450.000",
                "Perawatan plasma darah untuk regenerasi kulit.",
                "Membantu kulit lebih sehat dan muda."
            ),

            Treatment(
                "Dermaglow",
                "Rp 650.000",
                "Treatment glowing dengan nutrisi kulit.",
                "Kulit tampak lebih cerah."
            ),

            Treatment(
                "Injeksi Acne",
                "Start From Rp 35.000",
                "Injeksi khusus untuk jerawat meradang.",
                "Membantu mengempeskan jerawat lebih cepat."
            ),

            Treatment(
                "Injeksi VIT C",
                "Rp 125.000",
                "Injeksi vitamin C untuk tubuh dan kulit.",
                "Membantu meningkatkan daya tahan tubuh."
            )
        )
    ),

    // INFUS
    Category(
        "INFUS",
        listOf(

            Treatment(
                "Skin Refresher",
                "Rp 550.000",
                "Infus vitamin untuk menyegarkan tubuh.",
                "Tubuh terasa lebih fresh dan sehat."
            ),

            Treatment(
                "Bright Skin",
                "Rp 750.000",
                "Infus whitening dengan kandungan vitamin.",
                "Membantu kulit lebih cerah."
            ),

            Treatment(
                "Diamond Whitening",
                "Rp 950.000",
                "Infus premium untuk mencerahkan kulit.",
                "Kulit tampak lebih glowing."
            ),

            Treatment(
                "PDT + Mask",
                "Rp 50.000",
                "Perawatan tambahan dengan masker wajah.",
                "Membantu kulit lebih lembap."
            )
        )
    ),

    // CONTOURING
    Category(
        "CONTOURING",
        listOf(

            Treatment(
                "Botox Korea 50U",
                "Rp 1.500.000",
                "Botox untuk mengurangi garis halus.",
                "Wajah terlihat lebih muda."
            ),

            Treatment(
                "Botox Lanzox 50U",
                "Rp 2.999.000",
                "Botox premium dengan hasil lebih tahan lama.",
                "Membantu wajah lebih kencang."
            ),

            Treatment(
                "Filler Dagu Korea",
                "Start From Rp 1.500.000",
                "Filler untuk membentuk dagu.",
                "Membantu wajah terlihat lebih proporsional."
            ),

            Treatment(
                "Korea Nose Threadlift",
                "Rp 550.000/benang",
                "Threadlift untuk membentuk hidung.",
                "Hidung terlihat lebih mancung."
            ),

            Treatment(
                "Face Lift",
                "Rp 950.000/benang",
                "Pengencangan wajah dengan benang.",
                "Membantu wajah lebih kencang."
            )
        )
    )
)