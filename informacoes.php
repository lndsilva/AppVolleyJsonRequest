<?php
$user_name = "etecia";
$password = "123456";
$host = "localhost";
$db_name = "dbUsuario";
$con = mysqli_connect($host,$user_name,$password,$db_name);
$sql = "select * from tbUsuario where nome like '%maria%';";
$result = mysqli_query($con,$sql);
if(mysqli_num_rows($result)>0){

	$row = mysqli_fetch_assoc($result);

	echo json_encode(array("Nome"=>$row["nome"],"Email"=>$row["email"],"Mobile"=>$row["mobile"]));
}
?>