<?php
include_once('./securimage/securimage.php');
session_start();
$securimage = new Securimage();
var_dump($_SESSION);
if($securimage->check($_POST['captcha_code']) == false){
	echo "错误，<a href='javascript:history.go(-1)'>返回</a>重试"; 
	exit; 
}else{
	echo'验证码正确！';
}

?>
