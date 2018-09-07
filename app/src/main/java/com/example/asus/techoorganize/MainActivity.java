package com.example.asus.techoorganize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Context myContext;
    private Activity myActivity;
    private LinearLayout myLinearLayout;
    private PopupWindow myPopWindow = null;
    private TextView perPpsdm1, perPpsdm2, perPpsdm3, perPpsdm4, perOnline1, perOnline2, perOnline3, perRiset1, perRiset2,
            perRiset3, perDokumen1, perDokumen2, perDokumen3, perMedia1, perMedia2, perMedia3, perLogika1, perLogika2, perHumas1, perHumas2, perHumas3, perAdpen1, perAdpen2, perAdpen3;

    private RadioButton ppsdm11, ppsdm12, ppsdm13, ppsdm21, ppsdm22, ppsdm23, ppsdm31, ppsdm32, ppsdm33, ppsdm41, ppsdm42, ppsdm43, online11, online12,
            online13, online21, online22, online23, online31, online32, online33, riset11, riset12, riset13, riset21, riset22,
            riset23, riset31, riset32, riset33, dokumen11, dokumen12, dokumen13, dokumen21, dokumen22, dokumen23, dokumen31, dokumen32,
            dokumen33, media11, media12, media13, media21, media22, media23, media31, media32, media33, logika11, logika12, logika13,
            logika21, logika22, logika23, humas11, humas12, humas13, humas21, humas22, humas23, humas31, humas32, humas33, adpen11, adpen12,
            adpen13, adpen21, adpen22, adpen23, adpen31, adpen32, adpen33;

    private RadioGroup Gppsdm1, Gppsdm2, Gppsdm3, Gppsdm4, Gonline1, Gonline2, Gonline3, Griset1, Griset2, Griset3, Gdokumen1, Gdokumen2,
            Gdokumen3, Gmedia1, Gmedia2, Gmedia3, Glogika1, Glogika2, Ghumas1, Ghumas2, Ghumas3, Gadpen1, Gadpen2, Gadpen3;

    aksesDatabase dbHelper;
    Cursor cursor;
    String tampungAja, tampungAja2;
    Random r = new Random();
    double hasilDivisi;


    public double nilPpsdm1, nilPpsdm2, nilPpsdm3, nilPpsdm4, nilOnline1, nilOnline2, nilOnline3, nilRiset1, nilRiset2, nilRiset3, nilDokumen1,
            nilDokumen2, nilDokumen3, nilMedia1, nilMedia2, nilMedia3, nilLogika1, nilLogika2, nilHumas1, nilHumas2, nilHumas3,
            nilAdpen1, nilAdpen2, nilAdpen3;

    public double nilAkhirPpsdm, nilAkhirHumas, nilAkhirMedia, nilAkhirDokumen, nilAkhirRiset, nilAkhirLogika, nilAkhirapden, nilAkhirOnline;

    public String divisi;
    String insertNanya ="INSERT INTO `pertanyaan` VALUES (2,'Dalam beberapa kali rapat dan acara organisasi ada temen kamu yang jarang hadir (dinilai mulai tidak aktif). apa yang akan anda lakukan?',NULL)," +
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
            "(24,'Suatu ketika terdapat event menarik yang dapat diikuti oleh anda, teman anda, atau orang-orang disekitar anda. bagaimana reaksi anda setelah mengetahuinya?',NULL);";

    String insertJawaban="INSERT INTO `jawaban` VALUES " +
            "(1,'ikut memberikan ide dan masukan tetapi hanya yang berhubungan dengan divisi kamu, tidak peduli dengan hambatan yang dialami divisi lain',NULL),"+
            "(2,'ikut memberikan masukan dan ide, dan membantu apapun yang bisa kamu bantu meskipun tidak termasuk dalam divisi tersebut',NULL)," +
            "(3,'tidak peduli, ikut saja dengan hasil akhirnya dan menunggu jobdesk yang diberikan',NULL)," +
            "(4,'mencoba mencari tahu kendala yang dialami teman kamu,lalu mengobrol dan mengingatkannya untuk aktif kembali ',NULL)," +
            "(5,'mencoba mengobrol dengan teman kamu untuk mencari tahu kendala yang dialami teman kamu untuk mencari tahu kendala yang dialaminya. Masalah teman kamu akan aktif lagi atau tidak, kamu tidak peduli ',NULL)," +
            "(6,'tidak acuh sama sekali karena dirasa itu bukan tugas kamu ',NULL)," +
            "(7,'Tersenyum dan langsung menyapa ',NULL)," +
            "(8,'Acuh tak acuh ',NULL)," +
            "(9,'Tersenyum dan menunggu untuk disapa ',NULL)," +
            "(10,'mempengaruhi dan membujuk orang-orang di sekitar anda untuk mengikuti kompetisi   tersebut',NULL)," +
            "(11,'tidak jadi untuk mengikuti kompetisi tersebut',NULL)," +
            "(12,'mencari orang lain untuk mengikuti kompetisi tersebut',NULL)," +
            "(13,'suka membaca buku, puisi ataupun mengeluarkan pendapatnya dalam tulisan ',NULL)," +
            "(14,'suka bermain kata-kata, humor ataupun menciptakan kata-kata baru ',NULL)," +
            "(15,'suka berkomuniaksi dengan orang secara cepat dan rutin ',NULL)," +
            "(16,'selalu menggunakan kata-kata baku, sesuai EYD, dan diam beberapa detik sebelum berbicara',NULL)," +
            "(17,'menyesuaikan dengan lawan Bicara dan merespon langsung setelah lawan bicara selesai',NULL)," +
            "(18,'menggunakan bahasa sehari-hari dan berbicara secara spontan',NULL)," +
            "(19,'tidak memahami prioritas ',NULL)," +
            "(20,'tidak mau disiplin ',NULL)," +
            "(21,'mengembangkan keterampilan secara apa adanya',NULL)," +
            "(22,'berfikir secara tidak konvensional dan slalu ingin melakukan sesuatu',NULL)," +
            "(23,'berfikir secara visioner dan menemukan',NULL)," +
            "(24,'berfikir secara individualistik dan berhubungan dengan diri sendiri',NULL)," +
            "(25,'berani dalam melakukan sesuatu dan slalu ingin tahu ',NULL)," +
            "(26,'mandiri dalam berpikir dan menilai sesuatu',NULL)," +
            "(27,'tidak menerima penilaian dari orang lain dan orang yang teguh ',NULL)," +
            "(28,'suka dan sering ',NULL)," +
            "(29,'suka dan jarang ',NULL)," +
            "(30,'tidak suka dan tidak pernah ',NULL)," +
            "(31,'mengedit foto tersebut menggunakan tools atau filter pada gadget anda',NULL)," +
            "(32,'mengedit foto tersebut semaksimal mungkin menggunakan photoshop atau tools terbaik untuk mengedit foto',NULL)," +
            "(33,'membiarkan foto tersebut apa adanya',NULL)," +
            "(34,'merekam kejadian tersebut dengan menggunakan gadget anda',NULL)," +
            "(35,'membiarkan kejadian tersebut terjadi dan tidak merekamnya ',NULL)," +
            "(36,'memfoto kejadian tersebut ',NULL)," +
            "(37,'Menampilkan video apa adanya',NULL)," +
            "(38,'Video Diedit terlebih dahulu menggunakan tools editor video sebelum ditampilkan',NULL)," +
            "(39,'Membuat dan mengedit video yang akan ditampilkan semaksimal mungkin supaya menjadi lebih menarik',NULL)," +
            "(40,'mencari tahu tentang permasalahan tersebut',NULL)," +
            "(41,'mengamati permasalahan tersebut',NULL)," +
            "(42,'mencari tahu dan menemukan suatu inovasi untuk menyelesaikan permasalahan tersebut',NULL)," +
            "(43,'Sering',NULL)," +
            "(44,'kadang-kadang',NULL)," +
            "(45,'tidak pernah',NULL)," +
            "(46,'setiap hari ',NULL)," +
            "(47,'kadang-kadang ',NULL)," +
            "(48,'jarang',NULL)," +
            "(49,'diam saja',NULL)," +
            "(50,'mengambil ranting pohon tersebut',NULL)," +
            "(51,'melihat dan mengupdate di social media',NULL)," +
            "(52,'antusias dan ingin mengikutinya',NULL)," +
            "(53,'Tidak ingin mengikutinya ',NULL)," +
            "(54,'Biasa Saja  ',NULL)," +
            "(55,'aktif dan menggagas atau mengusulkan sesuatu',NULL)," +
            "(56,'diam saja',NULL)," +
            "(57,'mencatat dan mengusulkan sesuatu melalui teman',NULL)," +
            "(58,'mencari relasi dan sponsor sebanyak-banyaknya untuk menghimpun dana ',NULL)," +
            "(59,'mengajak orang-orang di sekitar anda untuk mengikuti suatu kegiatan yang menghasilkan dana',NULL)," +
            "(60,'meminta bantuan orang lain untuk mencari ide bagaimana cara untuk menghimpun dana',NULL)," +
            "(61,'berkenalan dan memulai pembicaraan',NULL)," +
            "(62,'memulai pembicaraan dan bersedia untuk berbicara mengemukakan pendapat di hadapan banyak orang (peserta forum tersebut)',NULL)," +
            "(63,'mengamati apa yang dibicarakan pada forum tersebut ',NULL)," +
            "(64,'melihat kabar atau berita tersebut dari internet',NULL)," +
            "(65,'tahu dari teman',NULL)," +
            "(66,'melihat kabar atau berita tersebut dari koran atau majalah',NULL)," +
            "(67,'Membroadcast atau memberitahukan suatu informasi penting kepada teman atau orang sekitar anda',NULL)," +
            "(68,'Update status terkini ',NULL)," +
            "(69,'Chatting',NULL)," +
            "(70,'membagikan atau menshare event tersebut melalui social media ',NULL)," +
            "(71,'langsung memberitahukan kepada teman-teman anda',NULL)," +
            "(72,'tidak memberitahukan event tersebut',NULL);";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        myContext = getApplicationContext();
        myActivity = MainActivity.this;
        myLinearLayout = (LinearLayout) findViewById(R.id.activity_main);

        dbHelper = new aksesDatabase(this);
        setelVariabel();
        perhitunganDss();
    }

    public void ambilNamaDivisi() {
        if (hasilDivisi == nilAkhirPpsdm) {
            divisi = "Pengembangan SDM";
        } else if (hasilDivisi == nilAkhirHumas) {
            divisi = "Humas";
        } else if (hasilDivisi == nilAkhirMedia) {
            divisi = "Multimedia";
        } else if (hasilDivisi == nilAkhirDokumen) {
            divisi = "Dokumentasi";
        } else if (hasilDivisi == nilAkhirRiset) {
            divisi = "Research";
        } else if (hasilDivisi == nilAkhirLogika) {
            divisi = "Logistik dan Akomodasi";
        } else if (hasilDivisi == nilAkhirapden) {
            divisi = "Advokasi dan Pendanaan";
        } else if (hasilDivisi == nilAkhirOnline) {
            divisi = "Online";
        }
    }

    public void pilihDivisi() {

        double[] divisi = new double[8];
        divisi[0] = nilAkhirPpsdm;
        divisi[1] = nilAkhirHumas;
        divisi[2] = nilAkhirMedia;
        divisi[3] = nilAkhirDokumen;
        divisi[4] = nilAkhirRiset;
        divisi[5] = nilAkhirLogika;
        divisi[6] = nilAkhirapden;
        divisi[7] = nilAkhirOnline;


        for (int j = 0; j < divisi.length; j++) {
            if (divisi[0] > divisi[j]) {
                hasilDivisi = divisi[0];
            } else {
                divisi[0] = divisi[j];
            }
            hasilDivisi = divisi[0];
        }
    }

    public void setelVariabel() {
        /*menginisialisasi variabel-variabel*/
        Gppsdm1 = (RadioGroup) findViewById(R.id.ppsdm1);
        Gppsdm2 = (RadioGroup) findViewById(R.id.ppsdm2);
        Gppsdm3 = (RadioGroup) findViewById(R.id.ppsdm3);
        Gppsdm4 = (RadioGroup) findViewById(R.id.ppsdm4);

        Gonline1 = (RadioGroup) findViewById(R.id.online1);
        Gonline2 = (RadioGroup) findViewById(R.id.online2);
        Gonline3 = (RadioGroup) findViewById(R.id.online3);

        Griset1 = (RadioGroup) findViewById(R.id.riset1);
        Griset2 = (RadioGroup) findViewById(R.id.riset2);
        Griset3 = (RadioGroup) findViewById(R.id.riset3);

        Gdokumen1 = (RadioGroup) findViewById(R.id.dokumen1);
        Gdokumen2 = (RadioGroup) findViewById(R.id.dokumen2);
        Gdokumen3 = (RadioGroup) findViewById(R.id.dokumen3);

        Gmedia1 = (RadioGroup) findViewById(R.id.media1);
        Gmedia2 = (RadioGroup) findViewById(R.id.media2);
        Gmedia3 = (RadioGroup) findViewById(R.id.media3);

        Glogika1 = (RadioGroup) findViewById(R.id.logika1);
        Glogika2 = (RadioGroup) findViewById(R.id.logika2);

        Ghumas1 = (RadioGroup) findViewById(R.id.humas1);
        Ghumas2 = (RadioGroup) findViewById(R.id.humas2);
        Ghumas3 = (RadioGroup) findViewById(R.id.humas3);

        Gadpen1 = (RadioGroup) findViewById(R.id.adpen1);
        Gadpen2 = (RadioGroup) findViewById(R.id.adpen2);
        Gadpen3 = (RadioGroup) findViewById(R.id.adpen3);

        /*Textview Pertanyaan*/
        perPpsdm1 = (TextView) findViewById(R.id.Tppsdm1);
        perPpsdm2 = (TextView) findViewById(R.id.Tppsdm2);
        perPpsdm3 = (TextView) findViewById(R.id.Tppsdm3);
        perPpsdm4 = (TextView) findViewById(R.id.Tppsdm4);


        SQLiteDatabase tarikData = dbHelper.getReadableDatabase();
        cursor = tarikData.rawQuery("select * from pertanyaan",null);

        /*Isi pertanyaan ppsdm*/
        cursor.moveToFirst();
        cursor.moveToPosition(0);
        tampungAja = cursor.getString(1).toString();
        perPpsdm1.setText("1). " + tampungAja);
        cursor.moveToPosition(1);
        tampungAja2 = cursor.getString(1).toString();
        perPpsdm2.setText("2). " + tampungAja2);
        cursor.moveToPosition(2);
        tampungAja = cursor.getString(1).toString();
        perPpsdm3.setText("3). " + tampungAja);
        cursor.moveToPosition(3);
        tampungAja = cursor.getString(1).toString();
        perPpsdm4.setText("4). " + tampungAja);

        /*isi pertanyaan humas*/
        perHumas1 = (TextView) findViewById(R.id.Thumas1);
        perHumas2 = (TextView) findViewById(R.id.Thumas2);
        perHumas3 = (TextView) findViewById(R.id.Thumas3);

        cursor.moveToPosition(4);
        tampungAja = cursor.getString(1).toString();
        perHumas1.setText("5). " + tampungAja);
        cursor.moveToPosition(5);
        tampungAja = cursor.getString(1).toString();
        perHumas2.setText("6). " + tampungAja);
        cursor.moveToPosition(6);
        tampungAja = cursor.getString(1).toString();
        perHumas3.setText("7). " + tampungAja);

        /*isi pertanyaan media*/
        perMedia1 = (TextView) findViewById(R.id.Tmedia1);
        perMedia2 = (TextView) findViewById(R.id.Tmedia2);
        perMedia3 = (TextView) findViewById(R.id.Tmedia3);

        cursor.moveToPosition(7);
        tampungAja = cursor.getString(1).toString();
        perMedia1.setText("8). " + tampungAja);
        cursor.moveToPosition(8);
        tampungAja = cursor.getString(1).toString();
        perMedia2.setText("9). " + tampungAja);
        cursor.moveToPosition(9);
        tampungAja = cursor.getString(1).toString();
        perMedia3.setText("10). " + tampungAja);

        /*isi pertanyaan dokumen*/
        perDokumen1 = (TextView) findViewById(R.id.Tdokumen1);
        perDokumen2 = (TextView) findViewById(R.id.Tdokumen2);
        perDokumen3 = (TextView) findViewById(R.id.Tdokumen3);

        cursor.moveToPosition(10);
        tampungAja = cursor.getString(1).toString();
        perDokumen1.setText("11). " + tampungAja);
        cursor.moveToPosition(11);
        tampungAja = cursor.getString(1).toString();
        perDokumen2.setText("12). " + tampungAja);
        cursor.moveToPosition(12);
        tampungAja = cursor.getString(1).toString();
        perDokumen3.setText("13). " + tampungAja);

         /*isi pertanyaan riset*/
        perRiset1 = (TextView) findViewById(R.id.Triset1);
        perRiset2 = (TextView) findViewById(R.id.Triset2);
        perRiset3 = (TextView) findViewById(R.id.Triset3);

        cursor.moveToPosition(13);
        tampungAja = cursor.getString(1).toString();
        perRiset1.setText("14). " + tampungAja);
        cursor.moveToPosition(14);
        tampungAja = cursor.getString(1).toString();
        perRiset2.setText("15). " + tampungAja);
        cursor.moveToPosition(15);
        tampungAja = cursor.getString(1).toString();
        perRiset3.setText("16). " + tampungAja);

         /*isi pertanyaan logika*/
        perLogika1 = (TextView) findViewById(R.id.Tlogika1);
        perLogika2 = (TextView) findViewById(R.id.Tlogika2);

        cursor.moveToPosition(16);
        tampungAja = cursor.getString(1).toString();
        perLogika1.setText("17). " + tampungAja);
        cursor.moveToPosition(17);
        tampungAja = cursor.getString(1).toString();
        perLogika2.setText("18). " + tampungAja);

        /*isi pertanyaan adpen*/
        perAdpen1 = (TextView) findViewById(R.id.Tadpen1);
        perAdpen2 = (TextView) findViewById(R.id.Tadpen2);
        perAdpen3 = (TextView) findViewById(R.id.Tadpen3);

        cursor.moveToPosition(18);
        tampungAja = cursor.getString(1).toString();
        perAdpen1.setText("19). " + tampungAja);
        cursor.moveToPosition(19);
        tampungAja = cursor.getString(1).toString();
        perAdpen2.setText("20). " + tampungAja);
        cursor.moveToPosition(20);
        tampungAja = cursor.getString(1).toString();
        perAdpen3.setText("21). " + tampungAja );

        /*isi pertanyaan online*/
        perOnline1 = (TextView) findViewById(R.id.Tonline1);
        perOnline2 = (TextView) findViewById(R.id.Tonline2);
        perOnline3 = (TextView) findViewById(R.id.Tonline3);

        cursor.moveToPosition(21);
        tampungAja = cursor.getString(1).toString();
        perOnline1.setText("22). " + tampungAja);
        cursor.moveToPosition(22);
        tampungAja = cursor.getString(1).toString();
        perOnline2.setText("23). " + tampungAja );
        cursor.moveToPosition(23);
        tampungAja = cursor.getString(1).toString();
        perOnline3.setText("24). " + tampungAja);

        /*inisialisasi radio button*/
        ppsdm11 = (RadioButton) findViewById(R.id.Jppsdm11);
        ppsdm12 = (RadioButton) findViewById(R.id.Jppsdm12);
        ppsdm13 = (RadioButton) findViewById(R.id.Jppsdm13);

        SQLiteDatabase tulisData = dbHelper.getWritableDatabase();
        cursor = tarikData.rawQuery("select * from jawaban",null);
        if (cursor.getCount() > 1) {

        } else {
            tulisData.execSQL(insertJawaban);
            cursor = tarikData.rawQuery("select * from jawaban",null);
        }

        cursor.moveToFirst();
        cursor.moveToPosition(0);
        tampungAja = cursor.getString(1).toString();
        ppsdm11.setText(tampungAja);
        cursor.moveToPosition(1);
        tampungAja = cursor.getString(1).toString();
        ppsdm12.setText(tampungAja);
        cursor.moveToPosition(2);
        tampungAja = cursor.getString(1).toString();
        ppsdm13.setText(tampungAja);

        ppsdm21 = (RadioButton) findViewById(R.id.Jppsdm21);
        ppsdm22 = (RadioButton) findViewById(R.id.Jppsdm22);
        ppsdm23 = (RadioButton) findViewById(R.id.Jppsdm23);

        cursor.moveToPosition(3);
        tampungAja = cursor.getString(1).toString();
        ppsdm21.setText(tampungAja);
        cursor.moveToPosition(4);
        tampungAja = cursor.getString(1).toString();
        ppsdm22.setText(tampungAja);
        cursor.moveToPosition(5);
        tampungAja = cursor.getString(1).toString();
        ppsdm23.setText(tampungAja);

        ppsdm31 = (RadioButton) findViewById(R.id.Jppsdm31);
        ppsdm32 = (RadioButton) findViewById(R.id.Jppsdm32);
        ppsdm33 = (RadioButton) findViewById(R.id.Jppsdm33);

        cursor.moveToPosition(6);
        tampungAja = cursor.getString(1).toString();
        ppsdm31.setText(tampungAja);
        cursor.moveToPosition(7);
        tampungAja = cursor.getString(1).toString();
        ppsdm32.setText(tampungAja);
        cursor.moveToPosition(8);
        tampungAja = cursor.getString(1).toString();
        ppsdm33.setText(tampungAja);

        ppsdm41 = (RadioButton) findViewById(R.id.Jppsdm41);
        ppsdm42 = (RadioButton) findViewById(R.id.Jppsdm42);
        ppsdm43 = (RadioButton) findViewById(R.id.Jppsdm43);

        cursor.moveToPosition(9);
        tampungAja = cursor.getString(1).toString();
        ppsdm41.setText(tampungAja);
        cursor.moveToPosition(10);
        tampungAja = cursor.getString(1).toString();
        ppsdm42.setText(tampungAja);
        cursor.moveToPosition(11);
        tampungAja = cursor.getString(1).toString();
        ppsdm43.setText(tampungAja);

         /*radiobutton humas*/
        humas11 = (RadioButton) findViewById(R.id.Jhumas11);
        humas12 = (RadioButton) findViewById(R.id.Jhumas12);
        humas13 = (RadioButton) findViewById(R.id.Jhumas13);

        cursor.moveToPosition(12);
        tampungAja = cursor.getString(1).toString();
        humas11.setText(tampungAja);
        cursor.moveToPosition(13);
        tampungAja = cursor.getString(1).toString();
        humas12.setText(tampungAja);
        cursor.moveToPosition(14);
        tampungAja = cursor.getString(1).toString();
        humas13.setText(tampungAja);

        humas21 = (RadioButton) findViewById(R.id.Jhumas21);
        humas22 = (RadioButton) findViewById(R.id.Jhumas22);
        humas23 = (RadioButton) findViewById(R.id.Jhumas23);

        cursor.moveToPosition(15);
        tampungAja = cursor.getString(1).toString();
        humas21.setText(tampungAja);
        cursor.moveToPosition(16);
        tampungAja = cursor.getString(1).toString();
        humas22.setText(tampungAja);
        cursor.moveToPosition(17);
        tampungAja = cursor.getString(1).toString();
        humas23.setText(tampungAja);

        humas31 = (RadioButton) findViewById(R.id.Jhumas31);
        humas32 = (RadioButton) findViewById(R.id.Jhumas32);
        humas33 = (RadioButton) findViewById(R.id.Jhumas33);

        cursor.moveToPosition(18);
        tampungAja = cursor.getString(1).toString();
        humas31.setText(tampungAja);
        cursor.moveToPosition(19);
        tampungAja = cursor.getString(1).toString();
        humas32.setText(tampungAja);
        cursor.moveToPosition(20);
        tampungAja = cursor.getString(1).toString();
        humas33.setText(tampungAja);

         /*radiobutton media*/
        media11 = (RadioButton) findViewById(R.id.Jmedia11);
        media12 = (RadioButton) findViewById(R.id.Jmedia12);
        media13 = (RadioButton) findViewById(R.id.Jmedia13);

        cursor.moveToPosition(21);
        tampungAja = cursor.getString(1).toString();
        media11.setText(tampungAja);
        cursor.moveToPosition(22);
        tampungAja = cursor.getString(1).toString();
        media12.setText(tampungAja);
        cursor.moveToPosition(23);
        tampungAja = cursor.getString(1).toString();
        media13.setText(tampungAja);

        media21 = (RadioButton) findViewById(R.id.Jmedia21);
        media22 = (RadioButton) findViewById(R.id.Jmedia22);
        media23 = (RadioButton) findViewById(R.id.Jmedia23);

        cursor.moveToPosition(24);
        tampungAja = cursor.getString(1).toString();
        media21.setText(tampungAja);
        cursor.moveToPosition(25);
        tampungAja = cursor.getString(1).toString();
        media22.setText(tampungAja);
        cursor.moveToPosition(26);
        tampungAja = cursor.getString(1).toString();
        media23.setText(tampungAja);

        media31 = (RadioButton) findViewById(R.id.Jmedia31);
        media32 = (RadioButton) findViewById(R.id.Jmedia32);
        media33 = (RadioButton) findViewById(R.id.Jmedia33);

        cursor.moveToPosition(27);
        tampungAja = cursor.getString(1).toString();
        media31.setText(tampungAja);
        cursor.moveToPosition(28);
        tampungAja = cursor.getString(1).toString();
        media32.setText(tampungAja);
        cursor.moveToPosition(29);
        tampungAja = cursor.getString(1).toString();
        media33.setText(tampungAja);

        /*radioButton dokumen*/
        dokumen11 = (RadioButton) findViewById(R.id.Jdokumen11);
        dokumen12 = (RadioButton) findViewById(R.id.Jdokumen12);
        dokumen13 = (RadioButton) findViewById(R.id.Jdokumen13);

        cursor.moveToPosition(30);
        tampungAja = cursor.getString(1).toString();
        dokumen11.setText(tampungAja);
        cursor.moveToPosition(31);
        tampungAja = cursor.getString(1).toString();
        dokumen12.setText(tampungAja);
        cursor.moveToPosition(32);
        tampungAja = cursor.getString(1).toString();
        dokumen13.setText(tampungAja);

        dokumen21 = (RadioButton) findViewById(R.id.Jdokumen21);
        dokumen22 = (RadioButton) findViewById(R.id.Jdokumen22);
        dokumen23 = (RadioButton) findViewById(R.id.Jdokumen23);

        cursor.moveToPosition(33);
        tampungAja = cursor.getString(1).toString();
        dokumen21.setText(tampungAja);
        cursor.moveToPosition(34);
        tampungAja = cursor.getString(1).toString();
        dokumen22.setText(tampungAja);
        cursor.moveToPosition(35);
        tampungAja = cursor.getString(1).toString();
        dokumen23.setText(tampungAja);

        dokumen31 = (RadioButton) findViewById(R.id.Jdokumen31);
        dokumen32 = (RadioButton) findViewById(R.id.Jdokumen32);
        dokumen33 = (RadioButton) findViewById(R.id.Jdokumen33);

        cursor.moveToPosition(36);
        tampungAja = cursor.getString(1).toString();
        dokumen31.setText(tampungAja);
        cursor.moveToPosition(37);
        tampungAja = cursor.getString(1).toString();
        dokumen32.setText(tampungAja);
        cursor.moveToPosition(38);
        tampungAja = cursor.getString(1).toString();
        dokumen33.setText(tampungAja);

        /*radioButton riset*/
        riset11 = (RadioButton) findViewById(R.id.Jriset11);
        riset12 = (RadioButton) findViewById(R.id.Jriset12);
        riset13 = (RadioButton) findViewById(R.id.Jriset13);

        cursor.moveToPosition(39);
        tampungAja = cursor.getString(1).toString();
        riset11.setText(tampungAja);
        cursor.moveToPosition(40);
        tampungAja = cursor.getString(1).toString();
        riset12.setText(tampungAja);
        cursor.moveToPosition(41);
        tampungAja = cursor.getString(1).toString();
        riset13.setText(tampungAja);

        riset21 = (RadioButton) findViewById(R.id.Jriset21);
        riset22 = (RadioButton) findViewById(R.id.Jriset22);
        riset23 = (RadioButton) findViewById(R.id.Jriset23);

        cursor.moveToPosition(42);
        tampungAja = cursor.getString(1).toString();
        riset21.setText(tampungAja);
        cursor.moveToPosition(43);
        tampungAja = cursor.getString(1).toString();
        riset22.setText(tampungAja);
        cursor.moveToPosition(44);
        tampungAja = cursor.getString(1).toString();
        riset23.setText(tampungAja);

        riset31 = (RadioButton) findViewById(R.id.Jriset31);
        riset32 = (RadioButton) findViewById(R.id.Jriset32);
        riset33 = (RadioButton) findViewById(R.id.Jriset33);

        cursor.moveToPosition(45);
        tampungAja = cursor.getString(1).toString();
        riset31.setText(tampungAja);
        cursor.moveToPosition(46);
        tampungAja = cursor.getString(1).toString();
        riset32.setText(tampungAja);
        cursor.moveToPosition(47);
        tampungAja = cursor.getString(1).toString();
        riset33.setText(tampungAja);

        //radioButton logistik
        logika11 = (RadioButton) findViewById(R.id.Jlogika11);
        logika12 = (RadioButton) findViewById(R.id.Jlogika12);
        logika13 = (RadioButton) findViewById(R.id.Jlogika13);

        cursor.moveToPosition(48);
        tampungAja = cursor.getString(1).toString();
        logika11.setText(tampungAja);
        cursor.moveToPosition(49);
        tampungAja = cursor.getString(1).toString();
        logika12.setText(tampungAja);
        cursor.moveToPosition(50);
        tampungAja = cursor.getString(1).toString();
        logika13.setText(tampungAja);

        logika21 = (RadioButton) findViewById(R.id.Jlogika21);
        logika22 = (RadioButton) findViewById(R.id.Jlogika22);
        logika23 = (RadioButton) findViewById(R.id.Jlogika23);

        cursor.moveToPosition(51);
        tampungAja = cursor.getString(1).toString();
        logika21.setText(tampungAja);
        cursor.moveToPosition(52);
        tampungAja = cursor.getString(1).toString();
        logika22.setText(tampungAja);
        cursor.moveToPosition(53);
        tampungAja = cursor.getString(1).toString();
        logika23.setText(tampungAja);

        //radioButton advokasi dan pendanaan
        adpen11 = (RadioButton) findViewById(R.id.Jadpen11);
        adpen12 = (RadioButton) findViewById(R.id.Jadpen12);
        adpen13 = (RadioButton) findViewById(R.id.Jadpen13);

        cursor.moveToPosition(54);
        tampungAja = cursor.getString(1).toString();
        adpen11.setText(tampungAja);
        cursor.moveToPosition(55);
        tampungAja = cursor.getString(1).toString();
        adpen12.setText(tampungAja);
        cursor.moveToPosition(56);
        tampungAja = cursor.getString(1).toString();
        adpen13.setText(tampungAja);

        adpen21 = (RadioButton) findViewById(R.id.Jadpen21);
        adpen22 = (RadioButton) findViewById(R.id.Jadpen22);
        adpen23 = (RadioButton) findViewById(R.id.Jadpen23);

        cursor.moveToPosition(57);
        tampungAja = cursor.getString(1).toString();
        adpen21.setText(tampungAja);
        cursor.moveToPosition(58);
        tampungAja = cursor.getString(1).toString();
        adpen22.setText(tampungAja);
        cursor.moveToPosition(59);
        tampungAja = cursor.getString(1).toString();
        adpen23.setText(tampungAja);

        adpen31 = (RadioButton) findViewById(R.id.Jadpen31);
        adpen32 = (RadioButton) findViewById(R.id.Jadpen32);
        adpen33 = (RadioButton) findViewById(R.id.Jadpen33);

        cursor.moveToPosition(60);
        tampungAja = cursor.getString(1).toString();
        adpen31.setText(tampungAja);
        cursor.moveToPosition(61);
        tampungAja = cursor.getString(1).toString();
        adpen32.setText(tampungAja);
        cursor.moveToPosition(62);
        tampungAja = cursor.getString(1).toString();
        adpen33.setText(tampungAja);

        /*radiobutton online*/
        online11 = (RadioButton) findViewById(R.id.Jonline11);
        online12 = (RadioButton) findViewById(R.id.Jonline12);
        online13 = (RadioButton) findViewById(R.id.Jonline13);

        cursor.moveToPosition(63);
        tampungAja = cursor.getString(1).toString();
        online11.setText(tampungAja);
        cursor.moveToPosition(64);
        tampungAja = cursor.getString(1).toString();
        online12.setText(tampungAja);
        cursor.moveToPosition(65);
        tampungAja = cursor.getString(1).toString();
        online13.setText(tampungAja);

        online21 = (RadioButton) findViewById(R.id.Jonline21);
        online22 = (RadioButton) findViewById(R.id.Jonline22);
        online23 = (RadioButton) findViewById(R.id.Jonline23);

        cursor.moveToPosition(66);
        tampungAja = cursor.getString(1).toString();
        online21.setText(tampungAja);
        cursor.moveToPosition(67);
        tampungAja = cursor.getString(1).toString();
        online22.setText(tampungAja);
        cursor.moveToPosition(68);
        tampungAja = cursor.getString(1).toString();
        online23.setText(tampungAja);

        online31 = (RadioButton) findViewById(R.id.Jonline31);
        online32 = (RadioButton) findViewById(R.id.Jonline32);
        online33 = (RadioButton) findViewById(R.id.Jonline33);

        cursor.moveToPosition(69);
        tampungAja = cursor.getString(1).toString();
        online31.setText(tampungAja);
        cursor.moveToPosition(70);
        tampungAja = cursor.getString(1).toString();
        online32.setText(tampungAja);
        cursor.moveToPosition(71);
        tampungAja = cursor.getString(1).toString();
        online33.setText(tampungAja);

    }


    public void perhitunganDss() {

        //PPSDM
        Gppsdm1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jppsdm11) {
                    nilPpsdm1 = 1.0;
                } else if (checkedId == R.id.Jppsdm12) {
                    nilPpsdm1 = 1.5;
                } else if (checkedId == R.id.Jppsdm13) {
                    nilPpsdm1 = 0.5;
                }
            }
        });


        Gppsdm2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jppsdm21) {
                    nilPpsdm2 = 1.5;
                } else if (checkedId == R.id.Jppsdm22) {
                    nilPpsdm2 = 1.0;
                } else if (checkedId == R.id.Jppsdm23) {
                    nilPpsdm2 = 0.5;
                }
            }
        });

        Gppsdm3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jppsdm31) {
                    nilPpsdm3 = 1.5;
                } else if (checkedId == R.id.Jppsdm32) {
                    nilPpsdm3 = 0.5;
                } else if (checkedId == R.id.Jppsdm33) {
                    nilPpsdm3 = 1.0;
                }
            }
        });

        Gppsdm4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jppsdm41) {
                    nilPpsdm4 = 1.5;
                } else if (checkedId == R.id.Jppsdm42) {
                    nilPpsdm4 = 0.5;
                } else if (checkedId == R.id.Jppsdm43) {
                    nilPpsdm4 = 1.0;
                }
            }
        });

        //ONLINE
        Gonline1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jonline11) {
                    nilOnline1 = 2.0;
                } else if (checkedId == R.id.Jonline12) {
                    nilOnline1 = 0.75;
                } else if (checkedId == R.id.Jonline13) {
                    nilOnline1 = 1.25;
                }
            }
        });

        Gonline2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jonline21) {
                    nilOnline2 = 2.0;
                } else if (checkedId == R.id.Jonline22) {
                    nilOnline2 = 1.25;
                } else if (checkedId == R.id.Jonline23) {
                    nilOnline2 = 0.75;
                }
            }
        });

        Gonline3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jonline31) {
                    nilOnline3 = 2.0;
                } else if (checkedId == R.id.Jonline32) {
                    nilOnline3 = 1.25;
                } else if (checkedId == R.id.Jonline33) {
                    nilOnline3 = 0.75;
                }
            }
        });


        //MEDIA
        Gmedia1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jmedia11) {
                    nilMedia1 = 1.25;
                } else if (checkedId == R.id.Jmedia12) {
                    nilMedia1 = 2.0;
                } else if (checkedId == R.id.Jmedia13) {
                    nilMedia1 = 0.75;
                }
            }
        });


        Gmedia2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jmedia21) {
                    nilMedia2 = 2.0;
                } else if (checkedId == R.id.Jmedia22) {
                    nilMedia2 = 1.25;
                } else if (checkedId == R.id.Jmedia23) {
                    nilMedia2 = 0.75;
                }
            }
        });

        Gmedia3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jmedia31) {
                    nilMedia3 = 2.0;
                } else if (checkedId == R.id.Jmedia32) {
                    nilMedia3 = 1.25;
                } else if (checkedId == R.id.Jmedia33) {
                    nilMedia3 = 0.75;
                }
            }
        });


        //HUMAS
        Ghumas1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jhumas11) {
                    nilHumas1 = 0.75;
                } else if (checkedId == R.id.Jhumas12) {
                    nilHumas1 = 2.0;
                } else if (checkedId == R.id.Jhumas13) {
                    nilHumas1 = 1.25;
                }
            }
        });

        Ghumas2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jhumas21) {
                    nilHumas2 = 2.0;
                } else if (checkedId == R.id.Jhumas22) {
                    nilHumas2 = 1.25;
                } else if (checkedId == R.id.Jhumas23) {
                    nilHumas2 = 0.75;
                }
            }
        });

        Ghumas3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jhumas31) {
                    nilHumas3 = 0.75;
                } else if (checkedId == R.id.Jhumas32) {
                    nilHumas3 = 1.25;
                } else if (checkedId == R.id.Jhumas33) {
                    nilHumas3 = 2.0;
                }
            }
        });


        //DOKUMENTASI
        Gdokumen1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jdokumen11) {
                    nilDokumen1 = 1.25;
                } else if (checkedId == R.id.Jdokumen12) {
                    nilDokumen1 = 2.0;
                } else if (checkedId == R.id.Jdokumen13) {
                    nilDokumen1 = 0.75;
                }
            }
        });

        Gdokumen2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jdokumen21) {
                    nilDokumen2 = 2.0;
                } else if (checkedId == R.id.Jdokumen22) {
                    nilDokumen2 = 0.75;
                } else if (checkedId == R.id.Jdokumen23) {
                    nilDokumen2 = 1.25;
                }
            }
        });

        Gdokumen3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jdokumen31) {
                    nilDokumen3 = 0.75;
                } else if (checkedId == R.id.Jdokumen32) {
                    nilDokumen3 = 1.25;
                } else if (checkedId == R.id.Jdokumen33) {
                    nilDokumen3 = 2.0;
                }
            }
        });


        //LOGISTIK
        Glogika1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jlogika11) {
                    nilLogika1 = 0.75;
                } else if (checkedId == R.id.Jlogika12) {
                    nilLogika1 = 2.0;
                } else if (checkedId == R.id.Jlogika13) {
                    nilLogika1 = 1.25;
                }
            }
        });

        Glogika2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jlogika21) {
                    nilLogika2 = 2.0;
                } else if (checkedId == R.id.Jlogika22) {
                    nilLogika2 = 0.75;
                } else if (checkedId == R.id.Jlogika13) {
                    nilLogika2 = 1.25;
                }
            }
        });


        //RISET
        Griset1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jriset11) {
                    nilRiset1 = 1.25;
                } else if (checkedId == R.id.Jriset12) {
                    nilRiset1 = 0.75;
                } else if (checkedId == R.id.Jriset13) {
                    nilRiset1 = 2.0;
                }

            }
        });

        Griset2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jriset21) {
                    nilRiset2 = 2.0;
                } else if (checkedId == R.id.Jriset22) {
                    nilRiset2 = 1.25;
                } else if (checkedId == R.id.Jriset23) {
                    nilRiset2 = 0.75;
                }
            }
        });

        Griset3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jriset31) {
                    nilRiset3 = 2.0;
                } else if (checkedId == R.id.Jriset32) {
                    nilRiset3 = 1.25;
                } else if (checkedId == R.id.Jriset33) {
                    nilRiset3 = 0.75;
                }
            }
        });


        //ADVOKASI DAN PENDANAAN
        Gadpen1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jadpen11) {
                    nilAdpen1 = 2.0;
                } else if (checkedId == R.id.Jadpen12) {
                    nilAdpen1 = 0.75;
                } else if (checkedId == R.id.Jadpen13) {
                    nilAdpen1 = 1.25;
                }
            }
        });
        Gadpen2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jadpen21) {
                    nilAdpen2 = 2.0;
                } else if (checkedId == R.id.Jadpen22) {
                    nilAdpen2 = 1.25;
                } else if (checkedId == R.id.Jadpen23) {
                    nilAdpen2 = 0.75;
                }
            }
        });

        Gadpen3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Jadpen31) {
                    nilAdpen3 = 1.25;
                } else if (checkedId == R.id.Jadpen32) {
                    nilAdpen3 = 2.0;
                } else if (checkedId == R.id.Jadpen33) {
                    nilAdpen3 = 0.75;
                }
            }
        });


    }

    public double ambilNilai(double data1, double data2, double bobot1, double bobot2) {


        double index = r.nextInt();
        double tampung11, tampung12, tampung21, tampung22;
        double hasilAkhir;
        double default1, default2;

        if (index % 2 == 0) {
            default1 = 3;
            default2 = 1;
        } else {
            default2 = 2;
            default1 = 1;
        }

        //menentukan nilai yang paling tinggi
        double maxSet1 = Math.max(data1, default1);
        double maxSet2 = Math.max(data2, default2);

        //rumus DSS
        tampung11 = data1 / maxSet1;
        tampung12 = data2 / maxSet2;

        tampung21 = default1 / maxSet1;
        tampung22 = default2 / maxSet2;

        //mengkalikan hasil normalisasi dengan bobot yang ada
        data1 = ((tampung11 * bobot1) + (tampung12 * bobot2));
        data2 = ((tampung21 * bobot1) + (tampung22 * bobot2));

        hasilAkhir = data1;
        return hasilAkhir;
    }

    public double ambilNilai(double data1, double data2, double data3, double data4,
                             double bobot1, double bobot2, double bobot3, double bobot4) {

        double index = r.nextInt();
        double tampung11, tampung12, tampung13, tampung14, tampung21, tampung22, tampung23, tampung24;
        double hasilAkhir;
        double default1, default2, default3, default4;

        if (index % 2 == 0) {
            default1 = 1;
            default2 = 1.5;
            default3 = 0.5;
            default4 = 1;
        } else {
            default2 = 1;
            default1 = 0.5;
            default3 = 1.5;
            default4 = 0.5;
        }

        //menentukan nilai yang paling tinggi
        double maxSet1 = Math.max(data1, default1);
        double maxSet2 = Math.max(data2, default2);
        double maxSet3 = Math.max(data3, default3);
        double maxSet4 = Math.max(data4, default4);

        //rumus DSS
        tampung11 = data1 / maxSet1;
        tampung12 = data2 / maxSet2;
        tampung13 = data3 / maxSet3;
        tampung14 = data4 / maxSet4;

        tampung21 = default1 / maxSet1;
        tampung22 = default2 / maxSet2;
        tampung23 = default3 / maxSet3;
        tampung24 = default4 / maxSet4;

        //mengkalikan hasil normalisasi dengan bobot yang ada
        data1 = ((tampung11 * bobot1) + (tampung12 * bobot2) + (tampung13 * bobot3) + (tampung14 * bobot4));
        data2 = ((tampung21 * bobot1) + (tampung22 * bobot2) + (tampung23 * bobot3) + (tampung24 * bobot4));

        hasilAkhir = data1;
        return hasilAkhir;
    }

    public double ambilNilai(double data1, double data2, double data3,
                             double bobot1, double bobot2, double bobot3) {

        double index = r.nextInt();
        double tampung11, tampung12, tampung13, tampung21, tampung22, tampung23;
        double hasilAkhir;
        double default1, default2, default3;

        if (index % 2 == 0) {
            default1 = 2;
            default2 = 1.25;
            default3 = 0.75;
        } else {
            default2 = 0.75;
            default1 = 1.25;
            default3 = 1.25;
        }
        //menentukan nilai yang paling tinggi
        double maxSet1 = Math.max(data1, default1);
        double maxSet2 = Math.max(data2, default2);
        double maxSet3 = Math.max(data3, default3);

        //rumus DSS
        tampung11 = data1 / maxSet1;
        tampung12 = data2 / maxSet2;
        tampung13 = data3 / maxSet3;

        tampung21 = default1 / maxSet1;
        tampung22 = default2 / maxSet2;
        tampung23 = default3 / maxSet3;

        //mengkalikan hasil normalisasi dengan bobot yang ada
        data1 = ((tampung11 * bobot1) + (tampung12 * bobot2) + (tampung13 * bobot3));
        data2 = ((tampung21 * bobot1) + (tampung22 * bobot2) + (tampung23 * bobot3));

        hasilAkhir = data1;
        return hasilAkhir;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bantuan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.popup_bantuan, null);

        if (myPopWindow != null) {
            myPopWindow.dismiss();
        }

        myPopWindow = new PopupWindow(customView,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        if (Build.VERSION.SDK_INT >= 21) {
            myPopWindow.setElevation(5.0f);
        }

        ImageButton closeButton = (ImageButton) customView.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPopWindow.dismiss();
            }
        });

        myPopWindow.showAtLocation(myLinearLayout, Gravity.CENTER, 0, 0);


        return super.onOptionsItemSelected(item);
    }

    public void setNilai() {
        double bobotPpsdm1 = 0.4;
        double bobotPpsdm2 = 0.2;
        double bobotPpsdm3 = 0.1;
        double bobotPpsdm4 = 0.3;

        nilAkhirPpsdm = ambilNilai(nilPpsdm1, nilPpsdm2, nilPpsdm3, nilPpsdm4, bobotPpsdm1, bobotPpsdm2, bobotPpsdm3, bobotPpsdm4);

        double bobotOnline1 = 0.3;
        double bobotOnline2 = 0.5;
        double bobotOnline3 = 0.2;

        nilAkhirOnline = ambilNilai(nilOnline1, nilOnline2, nilOnline3, bobotOnline1, bobotOnline2, bobotOnline3);

        double bobotMedia1 = 0.4;
        double bobotMedia2 = 0.2;
        double bobotMedia3 = 0.4;

        nilAkhirMedia = ambilNilai(nilMedia1, nilMedia2, nilMedia3, bobotMedia1, bobotMedia2, bobotMedia3);

        double bobotHumas1 = 0.15;
        double bobotHumas2 = 0.5;
        double bobotHumas3 = 0.35;

        nilAkhirHumas = ambilNilai(nilHumas1, nilHumas2, nilHumas3, bobotHumas1, bobotHumas2, bobotHumas3);

        double bobotDokumen1 = 0.35;
        double bobotDokumen2 = 0.35;
        double bobotDokumen3 = 0.3;

        nilAkhirDokumen = ambilNilai(nilDokumen1, nilDokumen2, nilDokumen3, bobotDokumen1, bobotDokumen2, bobotDokumen3);

        double bobotLogika1 = 0.6;
        double bobotLogika2 = 0.4;

        nilAkhirLogika = ambilNilai(nilLogika1, nilLogika2, bobotLogika1, bobotLogika2);

        double bobotRiset1 = 0.45;
        double bobotRiset2 = 0.4;
        double bobotRiset3 = 0.15;

        nilAkhirRiset = ambilNilai(nilRiset1, nilRiset2, nilRiset3, bobotRiset1, bobotRiset2, bobotRiset3);

        double bobotAdpen1 = 0.4;
        double bobotAdpen2 = 0.35;
        double bobotAdpen3 = 0.25;

        nilAkhirapden = ambilNilai(nilAdpen1, nilAdpen2, nilAdpen3, bobotAdpen1, bobotAdpen2, bobotAdpen3);
    }

    public void submitAja(View view) {
        setNilai();
        pilihDivisi();
        ambilNamaDivisi();

        Intent inet = new Intent(MainActivity.this, halHasil.class);
        inet.putExtra("divisi", divisi);
        startActivity(inet);
        finish();
    }
}
