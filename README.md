# <i>Rice Varieties Classification</i> (Klasifikasi Varietas Beras)
Aplikasi ini dibuat untuk melakukan klasifikasi tiga varietas beras (Basmathi, IR-64, dan Ketan) menggunakan metode CNN (<i>Convolutional Neural Network</i>).
Program CNN dibuat menggunakan infrastruktur <i>Google Colaboratory</i> dengan bahasa pemrograman <i>Python</i> dan menggunakan <i>Framework Keras</i> dan TensorFlow yang kemudian disimpan dalam bentuk <i>file Jupyter Notebooks</i> “.ipynb”. File dari program tersebut disimpan ke layanan repositori <i>web development</i> pada <i>Platform Github</i>.
<i>Dataset</i> pelatihan dan pengujian disimpan pada <i>Github</i> dengan 3 macam kelas (varietas Beras Basmathi, IR-64, dan Ketan). Masing-masing jumlah <i>dataset</i> pelatihan setiap kelas/varietas sebanyak 75 gambar dengan format ".jpeg" dan untuk <i>dataset</i> pengujian tiap kelasnya sebanyak 15 gambar berformat ".jpeg". Untuk <i>folder dataset</i> pelatihan dan pengujian disimpan pada folder yang terpisah agar memudahkan dalam melihat pengujiannya.
Pada program klasifikasi varietas beras ini menggunakan dua macam arsitektur CNN, yaitu arsitektur MobileNetV1 dan VGG-16Net.
Teknik yang digunakan pada kedua arsitektur tersebut dilakukan dengan cara <i>Feature Extraction</i>, yaitu mentransfer hasil pelatihan dari kedua arsitektur tersebut yang telah dilatih pada <i>dataset ImageNet</i> dan untuk klasifikasinya (<i>densely connected layer</i>) menggunakan teknik <i>Global Average Pooling</i>.

Setelah dilakukannya pengujian, model dari hasil pengujian tersebut dapat disimpan dan dikonversi ke dalam bentuk <i>file Tensorflow Lite</i> ".tflite". File tersebut nantinya digunakan sebagai model yang dapat diimpor ke <i>Android Studio</i> yang tentunya juga mengimpor <i>library tensorflow</i> pada build.gradle di dalam <i>project Android Studio</i>. Kemudian dibuat aplikasi Android untuk klasifikasi varietas beras dengan menggunakan fasilitas kamera pada perangkat <i>Smartphone Android</i>.

## Pelatihan dan Pembuatan Model pada <i>Google Colaboratory</i>
1. Klik salah satu file Jupyter Notebooks (.ipynb) pada repositori ini
2. Klik ikon "Open with Colab"
3. Masuk ke <i>Google Colab</i> dengan akun Google Anda
4. Klik menu "Runtime" kemudian pilih "Run All" atau tekan <b>Ctrl+F9</b> pada keyboard
5. Tunggu prosesnya hingga selesai (sekitar 5 sampai 10 menit, tergantung koneksi internet dan spesifikasi komputer Anda)
6. Unduh model (.tflite) yang sudah didapat dari proses pelatihan
7. Model tersebut nantinya dapat digunakan pada aplikasi Android.

## <i>Update Versi 2.0</i>
## Penggunaan Aplikasi Android
### Menggunakan Kamera
1. Download aplikasinya di dalam folder Output pada repositori ini. Misal untuk MobileNet : https://github.com/Soedirman-Machine-Learning/rice-varieties-classification/blob/master/Aplikasi%20Android/MobileNetV1/Update/Output/app-debug-mobilenet.apk
2. Buka Aplikasi Klasifikasi Varietas Beras kemudian pilih menu "PENDETEKSI VARIETAS BERAS"
3. Setelah terbuka menu tersebut arahkan kamera ke obyek varietas beras yang ingin dideteksi (jarak kamera dengan obyek sekitar 10 cm), kemudian klik/tap tombol "Deteksi"
4. Hasil prediksi akan muncul beberapa saat setelah menekan tombol "Deteksi" di bagian bawah layar dalam persentase (% diurutkan dari yang tertinggi). Persentase tertinggi merupakan hasil prediksi yang paling mendekati/mirip.
<img src="https://github.com/Soedirman-Machine-Learning/rice-varieties-classification/blob/master/ezgif-3-094c9401a638.gif" width="240" height="427">   <img src="https://github.com/Soedirman-Machine-Learning/rice-varieties-classification/blob/master/ezgif-3-377733b908a3.gif" width="240" height="427">

### Mengimpor Gambar dari Galeri Foto yang Sudah Tersimpan
1. Buka Aplikasi
2. Klik menu "PILIH GAMBAR" di bagian atas
3. Cari dan pilih gambar obyek beras yang akan dideteksi
4. Klik tombol Deteksi di bagian bawah
5. Hasil prediksi tertinggi akan muncul beberapa saat setelah menekan tombol "DETEKSI" di bagian bawah layar besertas tingkat probabilitasnya.
<img src="https://github.com/Soedirman-Machine-Learning/rice-varieties-classification/blob/master/ezgif-1-ed7d9804d3e6.gif" width="240" height="427">
