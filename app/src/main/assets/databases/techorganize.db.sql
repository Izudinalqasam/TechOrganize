BEGIN TRANSACTION;
CREATE TABLE `pertanyaan` (
	`id_pertanyaan`	INTEGER NOT NULL,
	`desc_pertanyaan`	TEXT NOT NULL,
	`id_jawaban`	INTEGER,
	PRIMARY KEY(`id_pertanyaan`)
);
INSERT INTO `pertanyaan` VALUES (1,'Jika kamu termasuk dalam kepanitiaan suatu acara yang terdiri dari beberapa divisi, tetapi persiapan acara yang kau rasakan tidak berjalan lancar karena adanya hambatan yang dialami salah satu divisi, apa yang akan kamu lakukan?',NULL);
INSERT INTO `pertanyaan` VALUES (2,'Dalam beberapa kali rapat dan acara organisasi ada temen kamu yang jarang hadir (dinilai mulai tidak aktif). apa yang akan anda lakukan?',NULL);
INSERT INTO `pertanyaan` VALUES (3,'Bagaimana reaksi anda bila bertemu seseorang yang belum anda kenal sebelumnya?',NULL);
INSERT INTO `pertanyaan` VALUES (4,'Suatu ketika terdapat kompetisi besar di lingkungan anda dan membutuhkan suatu tim untuk mengikuti kompetisi tersebut, apa yang akan  anda lakukan?',NULL);
INSERT INTO `pertanyaan` VALUES (5,'apa hal yang anda sukai dalam berbahasa ?',NULL);
INSERT INTO `pertanyaan` VALUES (6,'bagaimana cara anda dalam berbicara ?',NULL);
INSERT INTO `pertanyaan` VALUES (7,'tipe seperti apakah anda dalam manajemen diri ?',NULL);
INSERT INTO `pertanyaan` VALUES (8,'bagaimana cara anda berfikir kreatif ?',NULL);
INSERT INTO `pertanyaan` VALUES (9,'bagaimana anda melakukan aktivitas sehari-hari ?',NULL);
INSERT INTO `pertanyaan` VALUES (10,'apakah anda suka dan sering mendesign sesuatu ?',NULL);
INSERT INTO `pertanyaan` VALUES (11,'Apa yang anda lakukan setelah memfoto diri anda atau memfoto sebuah objek?',NULL);
INSERT INTO `pertanyaan` VALUES (12,'Apa yang anda lakukan ketika terjadi moment atau kejadian berharga yang jarang terjadi di sekitar anda?',NULL);
INSERT INTO `pertanyaan` VALUES (13,'Suatu ketika anda akan menampilkan video mengenai moment berharga anda, apa yang akan anda lakukan?',NULL);
INSERT INTO `pertanyaan` VALUES (14,'Suatu ketika terjadi permasalahan mengenai lingkungan yang tidak biasa, bagaimana reaksi anda?',NULL);
INSERT INTO `pertanyaan` VALUES (15,'Apakah anda sering membaca suatu artikel atau jurnal?',NULL);
INSERT INTO `pertanyaan` VALUES (16,'Seberapa sering anda membaca suatu berita melalui koran,internet, atau majalah/koran digital?',NULL);
INSERT INTO `pertanyaan` VALUES (17,'Suatu ketika anda melihat suatu ranting pohon yang jatuh dan dapat mengganggu atau menghalangi seseorang untuk berjalan, apa reaksi anda?',NULL);
INSERT INTO `pertanyaan` VALUES (18,'Ketika anda ditawarkan untuk mengikuti suatu kepanitiaan sebuah acara yang belum diikuti sebelumnya. Bagaimana reaksi anda?',NULL);
INSERT INTO `pertanyaan` VALUES (19,'Suatu ketika anda menghadiri suatu konferensi mengenai isu permasalahan sekitar,   bagaimana reaksi anda pada konferensi tersebut?',NULL);
INSERT INTO `pertanyaan` VALUES (20,'Pada suatu ketika anda bertugas untuk menghimpun dana yang cukup banyak untuk suatu event. apa yang akan anda lakukan?',NULL);
INSERT INTO `pertanyaan` VALUES (21,'Suatu ketika anda menghadiri suatu forum dan bertemu dengan orang-orang yang belum anda kenal sebelumnya, apa yang akan anda lakukan?',NULL);
INSERT INTO `pertanyaan` VALUES (22,'Bagaimana anda tahu tentang berita atau kabar terbaru di sekitar anda?',NULL);
INSERT INTO `pertanyaan` VALUES (23,'Apa yang biasa anda lakukan ketika menggunakan social media?',NULL);
INSERT INTO `pertanyaan` VALUES (24,'Suatu ketika terdapat event menarik yang dapat diikuti oleh anda, teman anda, atau orang-orang disekitar anda. bagaimana reaksi anda setelah mengetahuinya?',NULL);
CREATE TABLE `kandidat` (
	`id_user`	INTEGER NOT NULL,
	`nama__user`	TEXT NOT NULL,
	`kriteria_ppsdm_satu`	INTEGER NOT NULL,
	`kriteria_ppsdm_dua`	INTEGER NOT NULL,
	`kriteria_ppsdm_tiga`	INTEGER NOT NULL,
	`kriteria_ppsdm_empat`	INTEGER NOT NULL,
	`kriteria_humas_satu`	INTEGER NOT NULL,
	`kriteria_humas_dua`	INTEGER NOT NULL,
	`kriteria_humas_tiga`	INTEGER NOT NULL,
	`kriteria_media_satu`	INTEGER NOT NULL,
	`kriteria_media_dua`	INTEGER NOT NULL,
	`kriteria_media_tiga`	INTEGER NOT NULL,
	`kriteria_dokumen_satu`	INTEGER NOT NULL,
	`kriteria_dokumen_dua`	INTEGER NOT NULL,
	`kriteria_dokumen_tiga`	INTEGER NOT NULL,
	`kriteria_riset_satu`	INTEGER NOT NULL,
	`kriteria_riset_dua`	INTEGER NOT NULL,
	`kriteria_riset_tiga`	INTEGER NOT NULL,
	`kriteria_logistik_satu`	INTEGER NOT NULL,
	`kriteria_logistik_dua`	INTEGER NOT NULL,
	`kriteria_adpen_satu`	INTEGER NOT NULL,
	`kriteria_adpen_dua`	INTEGER NOT NULL,
	`kriteria_adpen_tiga`	INTEGER NOT NULL,
	`kriteria_online_satu`	INTEGER NOT NULL,
	`kriteria_online_dua`	INTEGER NOT NULL,
	`kriteria_online_tiga`	INTEGER NOT NULL,
	PRIMARY KEY(`id_user`)
);
INSERT INTO `kandidat` VALUES (1,'Izzuddin',1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
CREATE TABLE `jawaban` (
	`id_jawaban`	INTEGER NOT NULL,
	`desc_jawaban`	TEXT NOT NULL,
	`bobot`	INTEGER,
	PRIMARY KEY(`id_jawaban`)
);
INSERT INTO `jawaban` VALUES (1,'ikut memberikan ide dan masukan tetapi hanya yang berhubungan dengan divisi kamu, tidak peduli dengan hambatan yang dialami divisi lain',NULL);
INSERT INTO `jawaban` VALUES (2,'ikut memberikan masukan dan ide, dan membantu apapun yang bisa kamu bantu meskipun tidak termasuk dalam divisi tersebut',NULL);
INSERT INTO `jawaban` VALUES (3,'tidak peduli, ikut saja dengan hasil akhirnya dan menunggu jobdesk yang diberikan',NULL);
INSERT INTO `jawaban` VALUES (4,'mencoba mencari tahu kendala yang dialami teman kamu,lalu mengobrol dan mengingatkannya untuk aktif kembali ',NULL);
INSERT INTO `jawaban` VALUES (5,'mencoba mengobrol dengan teman kamu untuk mencari tahu kendala yang dialami teman kamu untuk mencari tahu kendala yang dialaminya. Masalah teman kamu akan aktif lagi atau tidak, kamu tidak peduli ',NULL);
INSERT INTO `jawaban` VALUES (6,'tidak acuh sama sekali karena dirasa itu bukan tugas kamu ',NULL);
INSERT INTO `jawaban` VALUES (7,'Tersenyum dan langsung menyapa ',NULL);
INSERT INTO `jawaban` VALUES (8,'Acuh tak acuh ',NULL);
INSERT INTO `jawaban` VALUES (9,'Tersenyum dan menunggu untuk disapa ',NULL);
INSERT INTO `jawaban` VALUES (10,'mempengaruhi dan membujuk orang-orang di sekitar anda untuk mengikuti kompetisi   tersebut',NULL);
INSERT INTO `jawaban` VALUES (11,'tidak jadi untuk mengikuti kompetisi tersebut',NULL);
INSERT INTO `jawaban` VALUES (12,'mencari orang lain untuk mengikuti kompetisi tersebut',NULL);
INSERT INTO `jawaban` VALUES (13,'suka membaca buku, puisi ataupun mengeluarkan pendapatnya dalam tulisan ',NULL);
INSERT INTO `jawaban` VALUES (14,'suka bermain kata-kata, humor ataupun menciptakan kata-kata baru ',NULL);
INSERT INTO `jawaban` VALUES (15,'suka berkomuniaksi dengan orang secara cepat dan rutin ',NULL);
INSERT INTO `jawaban` VALUES (16,'selalu menggunakan kata-kata baku, sesuai EYD, dan diam beberapa detik sebelum berbicara',NULL);
INSERT INTO `jawaban` VALUES (17,'menyesuaikan dengan lawan Bicara dan merespon langsung setelah lawan bicara selesai',NULL);
INSERT INTO `jawaban` VALUES (18,'menggunakan bahasa sehari-hari dan berbicara secara spontan',NULL);
INSERT INTO `jawaban` VALUES (19,'tidak memahami prioritas ',NULL);
INSERT INTO `jawaban` VALUES (20,'tidak mau disiplin ',NULL);
INSERT INTO `jawaban` VALUES (21,'mengembangkan keterampilan secara apa adanya',NULL);
INSERT INTO `jawaban` VALUES (22,'berfikir secara tidak konvensional dan slalu ingin melakukan sesuatu',NULL);
INSERT INTO `jawaban` VALUES (23,'berfikir secara visioner dan menemukan',NULL);
INSERT INTO `jawaban` VALUES (24,'berfikir secara individualistik dan berhubungan dengan diri sendiri',NULL);
INSERT INTO `jawaban` VALUES (25,'berani dalam melakukan sesuatu dan slalu ingin tahu ',NULL);
INSERT INTO `jawaban` VALUES (26,'mandiri dalam berpikir dan menilai sesuatu',NULL);
INSERT INTO `jawaban` VALUES (27,'tidak menerima penilaian dari orang lain dan orang yang teguh ',NULL);
INSERT INTO `jawaban` VALUES (28,'suka dan sering ',NULL);
INSERT INTO `jawaban` VALUES (29,'suka dan jarang ',NULL);
INSERT INTO `jawaban` VALUES (30,'tidak suka dan tidak pernah ',NULL);
INSERT INTO `jawaban` VALUES (31,'mengedit foto tersebut menggunakan tools atau filter pada gadget anda',NULL);
INSERT INTO `jawaban` VALUES (32,'mengedit foto tersebut semaksimal mungkin menggunakan photoshop atau tools terbaik untuk mengedit foto',NULL);
INSERT INTO `jawaban` VALUES (33,'membiarkan foto tersebut apa adanya',NULL);
INSERT INTO `jawaban` VALUES (34,'merekam kejadian tersebut dengan menggunakan gadget anda',NULL);
INSERT INTO `jawaban` VALUES (35,'membiarkan kejadian tersebut terjadi dan tidak merekamnya ',NULL);
INSERT INTO `jawaban` VALUES (36,'memfoto kejadian tersebut ',NULL);
INSERT INTO `jawaban` VALUES (37,'Menampilkan video apa adanya',NULL);
INSERT INTO `jawaban` VALUES (38,'Video Diedit terlebih dahulu menggunakan tools editor video sebelum ditampilkan',NULL);
INSERT INTO `jawaban` VALUES (39,'Membuat dan mengedit video yang akan ditampilkan semaksimal mungkin supaya menjadi lebih menarik',NULL);
INSERT INTO `jawaban` VALUES (40,'mencari tahu tentang permasalahan tersebut',NULL);
INSERT INTO `jawaban` VALUES (41,'mengamati permasalahan tersebut',NULL);
INSERT INTO `jawaban` VALUES (42,'mencari tahu dan menemukan suatu inovasi untuk menyelesaikan permasalahan tersebut',NULL);
INSERT INTO `jawaban` VALUES (43,'Sering',NULL);
INSERT INTO `jawaban` VALUES (44,'kadang-kadang',NULL);
INSERT INTO `jawaban` VALUES (45,'tidak pernah',NULL);
INSERT INTO `jawaban` VALUES (46,'setiap hari ',NULL);
INSERT INTO `jawaban` VALUES (47,'kadang-kadang ',NULL);
INSERT INTO `jawaban` VALUES (48,'jarang',NULL);
INSERT INTO `jawaban` VALUES (49,'diam saja',NULL);
INSERT INTO `jawaban` VALUES (50,'mengambil ranting pohon tersebut',NULL);
INSERT INTO `jawaban` VALUES (51,'melihat dan mengupdate di social media',NULL);
INSERT INTO `jawaban` VALUES (52,'antusias dan ingin mengikutinya',NULL);
INSERT INTO `jawaban` VALUES (53,'Tidak ingin mengikutinya ',NULL);
INSERT INTO `jawaban` VALUES (54,'Biasa Saja  ',NULL);
INSERT INTO `jawaban` VALUES (55,'aktif dan menggagas atau mengusulkan sesuatu',NULL);
INSERT INTO `jawaban` VALUES (56,'diam saja',NULL);
INSERT INTO `jawaban` VALUES (57,'mencatat dan mengusulkan sesuatu melalui teman',NULL);
INSERT INTO `jawaban` VALUES (58,'mencari relasi dan sponsor sebanyak-banyaknya untuk menghimpun dana ',NULL);
INSERT INTO `jawaban` VALUES (59,'mengajak orang-orang di sekitar anda untuk mengikuti suatu kegiatan yang menghasilkan dana',NULL);
INSERT INTO `jawaban` VALUES (60,'meminta bantuan orang lain untuk mencari ide bagaimana cara untuk menghimpun dana',NULL);
INSERT INTO `jawaban` VALUES (61,'berkenalan dan memulai pembicaraan',NULL);
INSERT INTO `jawaban` VALUES (62,'memulai pembicaraan dan bersedia untuk berbicara mengemukakan pendapat di hadapan banyak orang (peserta forum tersebut)',NULL);
INSERT INTO `jawaban` VALUES (63,'mengamati apa yang dibicarakan pada forum tersebut ',NULL);
INSERT INTO `jawaban` VALUES (64,'melihat kabar atau berita tersebut dari internet',NULL);
INSERT INTO `jawaban` VALUES (65,'tahu dari teman',NULL);
INSERT INTO `jawaban` VALUES (66,'melihat kabar atau berita tersebut dari koran atau majalah',NULL);
INSERT INTO `jawaban` VALUES (67,'Membroadcast atau memberitahukan suatu informasi penting kepada teman atau orang sekitar anda',NULL);
INSERT INTO `jawaban` VALUES (68,'Update status terkini ',NULL);
INSERT INTO `jawaban` VALUES (69,'Chatting',NULL);
INSERT INTO `jawaban` VALUES (70,'membagikan atau menshare event tersebut melalui social media ',NULL);
INSERT INTO `jawaban` VALUES (71,'langsung memberitahukan kepada teman-teman anda  ',NULL);
INSERT INTO `jawaban` VALUES (72,'tidak memberitahukan event tersebut',NULL);
CREATE TABLE `divisi` (
	`id_divisi`	INTEGER NOT NULL UNIQUE,
	`nama_divisi`	TEXT NOT NULL UNIQUE,
	`desc_divisi`	TEXT NOT NULL,
	PRIMARY KEY(`id_divisi`)
);
INSERT INTO `divisi` VALUES (1,'Research','Research(Kominfo) ini bertugas menyusun informasi secara detail, dan melakukan penelitian');
INSERT INTO `divisi` VALUES (2,'Dokumentasi','Dokumentasi(Kominfo) ini bertugas mengambil gambar atau video pada setiap event');
INSERT INTO `divisi` VALUES (3,'Online','Online(kominfo) bertugas menyebarkan atau membagikan informasi melalui blog atau social media, biasanya di divisi ini selalu aktif di social media');
INSERT INTO `divisi` VALUES (4,'Multimedia','Multimedia(kominfo) ini bertugas membuat desain poster, poster digital, atau desain banner untuk suatu event');
INSERT INTO `divisi` VALUES (5,'Pengembangan SDM','pada divisi ini bertugas untuk mengajak anggota-anggota untuk mengikuti suatu event');
INSERT INTO `divisi` VALUES (6,'Logistik dan Akomodasi','pada divisi ini bertugas menyiapkan peralatan yang ingin digunakan pada suatu event, serta yang memberi tahu arah lokasi ke venue pada setiap event');
INSERT INTO `divisi` VALUES (7,'Advokasi dan Pendanaan','pada divisi ini bertugas mencari dana untuk setiap event dan untuk mencari sponsor untuk suatu acara atau menjalin hubungan dengan komunitas lain');
INSERT INTO `divisi` VALUES (8,'Humas','bertugas memberi tahu atau menjarkom para anggota earth hour depok bila ada informasi ');
COMMIT;
