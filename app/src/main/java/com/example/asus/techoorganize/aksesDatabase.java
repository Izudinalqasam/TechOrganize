package com.example.asus.techoorganize;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ASUS on 21/05/2017.
 */

public class aksesDatabase extends SQLiteOpenHelper {
    private final static String DB_name = "techno.db";

    public aksesDatabase(Context context) {
        super(context,DB_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `pertanyaan` (\n" +
                "\t`id_pertanyaan`\tINTEGER NOT NULL,\n" +
                "\t`desc_pertanyaan`\tTEXT NOT NULL,\n" +
                "\t`id_jawaban`\tINTEGER,\n" +
                "\tPRIMARY KEY(`id_pertanyaan`)\n" +
                ");");

        db.execSQL("CREATE TABLE `kandidat` ( `id_user` INTEGER NOT NULL, `nama__user` TEXT NOT NULL, `kriteria_ppsdm_satu` INTEGER NOT NULL, " +
                "`kriteria_ppsdm_dua` INTEGER NOT NULL, `kriteria_ppsdm_tiga` INTEGER NOT NULL, `kriteria_ppsdm_empat` INTEGER NOT NULL, " +
                "`kriteria_humas_satu` INTEGER NOT NULL, `kriteria_humas_dua` INTEGER NOT NULL, `kriteria_humas_tiga` INTEGER NOT NULL, " +
                "`kriteria_media_satu` INTEGER NOT NULL, `kriteria_media_dua` INTEGER NOT NULL, `kriteria_media_tiga` INTEGER NOT NULL, " +
                "`kriteria_dokumen_satu` INTEGER NOT NULL, `kriteria_dokumen_dua` INTEGER NOT NULL, `kriteria_dokumen_tiga` INTEGER NOT NULL, " +
                "`kriteria_riset_satu` INTEGER NOT NULL, `kriteria_riset_dua` INTEGER NOT NULL, `kriteria_riset_tiga` INTEGER NOT NULL, " +
                "`kriteria_logistik_satu` INTEGER NOT NULL, `kriteria_logistik_dua` INTEGER NOT NULL, `kriteria_adpen_satu` INTEGER NOT NULL, " +
                "`kriteria_adpen_dua` INTEGER NOT NULL, `kriteria_adpen_tiga` INTEGER NOT NULL, `kriteria_online_satu` INTEGER NOT NULL, " +
                "`kriteria_online_dua` INTEGER NOT NULL, `kriteria_online_tiga` INTEGER NOT NULL, PRIMARY KEY(`id_user`) );");

        db.execSQL("CREATE TABLE `divisi` ( `id_divisi` INTEGER NOT NULL UNIQUE, `nama_divisi` TEXT NOT NULL UNIQUE, `desc_divisi` TEXT NOT NULL, PRIMARY KEY(`id_divisi`) );");

        db.execSQL("INSERT INTO `kandidat` VALUES (1,'Izzuddin',1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);");

        db.execSQL("INSERT INTO `divisi` VALUES (1,'Research','Research(Kominfo) ini bertugas menyusun informasi secara detail, dan melakukan penelitian');");

        db.execSQL("INSERT INTO `pertanyaan` VALUES (1,'Jika kamu termasuk dalam kepanitiaan suatu acara yang terdiri dari beberapa divisi, tetapi persiapan acara yang kau rasakan tidak berjalan lancar karena adanya hambatan yang dialami salah satu divisi, apa yang akan kamu lakukan?',NULL),"+
                "(2,'Dalam beberapa kali rapat dan acara organisasi ada temen kamu yang jarang hadir (dinilai mulai tidak aktif). apa yang akan anda lakukan?',NULL)," +
                "(3,'Bagaimana reaksi anda bila bertemu seseorang yang belum anda kenal sebelumnya?',NULL)," +
                "(4,'Suatu ketika terdapat kompetisi besar di lingkungan anda dan membutuhkan suatu tim untuk mengikuti kompetisi tersebut, apa yang akan  anda lakukan?',NULL),"+
                "(5,'apa hal yang anda sukai dalam berbahasa ?',NULL)," +
                "(6,'bagaimana cara anda dalam berbicara ?',NULL)," +
                "(7,'tipe seperti apakah anda dalam manajemen diri ?',NULL)," +
                "(8,'bagaimana cara anda berfikir kreatif ?',NULL)," +
                "(9,'bagaimana anda melakukan aktivitas sehari-hari ?',NULL)," +
                "(10,'apakah anda suka dan sering mendesign sesuatu ?',NULL)," +
                "(11,'Apa yang anda lakukan setelah memfoto diri anda atau memfoto sebuah objek?',NULL)," +
                "(12,'Apa yang anda lakukan ketika terjadi moment atau kejadian berharga yang jarang terjadi di sekitar anda?',NULL)," +
                "(13,'Suatu ketika anda akan menampilkan video mengenai moment berharga anda, apa yang akan anda lakukan?',NULL)," +
                "(14,'Suatu ketika terjadi permasalahan mengenai lingkungan yang tidak biasa, bagaimana reaksi anda?',NULL)," +
                "(15,'Apakah anda sering membaca suatu artikel atau jurnal?',NULL)," +
                "(16,'Seberapa sering anda membaca suatu berita melalui koran,internet, atau majalah/koran digital?',NULL)," +
                "(17,'Suatu ketika anda melihat suatu ranting pohon yang jatuh dan dapat mengganggu atau menghalangi seseorang untuk berjalan, apa reaksi anda?',NULL)," +
                "(18,'Ketika anda ditawarkan untuk mengikuti suatu kepanitiaan sebuah acara yang belum diikuti sebelumnya. Bagaimana reaksi anda?',NULL)," +
                "(19,'Suatu ketika anda menghadiri suatu konferensi mengenai isu permasalahan sekitar,   bagaimana reaksi anda pada konferensi tersebut?',NULL)," +
                "(20,'Pada suatu ketika anda bertugas untuk menghimpun dana yang cukup banyak untuk suatu event. apa yang akan anda lakukan?',NULL)," +
                "(21,'Suatu ketika anda menghadiri suatu forum dan bertemu dengan orang-orang yang belum anda kenal sebelumnya, apa yang akan anda lakukan?',NULL)," +
                "(22,'Bagaimana anda tahu tentang berita atau kabar terbaru di sekitar anda?',NULL)," +
                "(23,'Apa yang biasa anda lakukan ketika menggunakan social media?',NULL)," +
                "(24,'Suatu ketika terdapat event menarik yang dapat diikuti oleh anda, teman anda, atau orang-orang disekitar anda. bagaimana reaksi anda setelah mengetahuinya?',NULL);");

        db.execSQL("CREATE TABLE `jawaban` ( `id_jawaban` INTEGER NOT NULL, `desc_jawaban` TEXT NOT NULL, `bobot` INTEGER, PRIMARY KEY(`id_jawaban`) );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
