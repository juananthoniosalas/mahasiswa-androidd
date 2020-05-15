<?php

include("config.php");

$nama_mahasiswa = $_POST['nama_mahasiswa'];
$nomor_mahasiswa = $_POST['nomor_mahasiswa'];
$alamat_mahasiswa = $_POST['alamat_mahasiswa'];
$id_data = $_POST['id_data'];

$sql = "INSERT INTO data_mahasiswa VALUES ( '$id_data','$nama_mahasiswa' , '$nomor_mahasiswa', '$alamat_mahasiswa' )";
$query = mysqli_query($db , $sql);

// apakah query update berhasil ?
if ($query) {
  // code...
} else {
  // kalau gagal tampilkan pesan
  die("Gagal menyimpan perubahan");
}
