<?php

/**
 * Project:     Securimage: A PHP class for creating and managing form CAPTCHA images<br />
 * File:        securimage_show.php<br />
 *
 * Copyright (c) 2013, Drew Phillips
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *  - Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * Any modifications to the library should be indicated clearly in the source code
 * to inform users that the changes are not a part of the original software.<br /><br />
 *
 * If you found this script useful, please take a quick moment to rate it.<br />
 * http://www.hotscripts.com/rate/49400.html  Thanks.
 *
 * @link http://www.phpcaptcha.org Securimage PHP CAPTCHA
 * @link http://www.phpcaptcha.org/latest.zip Download Latest Version
 * @link http://www.phpcaptcha.org/Securimage_Docs/ Online Documentation
 * @copyright 2013 Drew Phillips
 * @author Drew Phillips <drew@drew-phillips.com>
  * @version 3.5.1 (June 21, 2013)
 * @package Securimage
 *
 */

// Remove the "//" from the following line for debugging problems
// error_reporting(E_ALL); ini_set('display_errors', 1);

require_once dirname(__FILE__) . '/securimage.php';

$img = new Securimage();

// 如果你想通过改变下面的设置来定制验证码，去掉//
// You can customize the image by making changes below, some examples are included - remove the "//" to uncomment

//$img->ttf_file        = './Quiff.ttf';
//$img->captcha_type    = Securimage::SI_CAPTCHA_MATHEMATIC; // 验证码是一道简单的数学题而再是纯文本
//$img->case_sensitive  = true;                              // true的话为验证码区分大小写（不推荐）
//$img->image_height    = 90;                                // 验证码高度
//$img->image_width     = $img->image_height * M_E;          // 非常棒的公式-通过高度计算宽度
$img->perturbation    = mt_rand(70,100)/100;                 // 1.0 = 高失真度, 数字更大 = 更大的失真度
//$img->image_bg_color  = new Securimage_Color("#0099CC");   // 验证码背景颜色
//$img->text_color      = new Securimage_Color("#EAEAEA");   // captcha 文本颜色
$img->num_lines       = mt_rand(5,10);                       // 图像上干扰线的数量
//$img->line_color      = new Securimage_Color("#0000CC");   // 干扰线颜色
//$img->image_type      = SI_IMAGE_JPEG;                     // 渲染jpeg验证码
//$img->use_transparent_text      = false;          	     // 关闭验证码透明度
//$img->signature_color = new Securimage_Color(rand(0, 64),
//                                             rand(64, 128),
//                                             rand(128, 255));  // 随机签名颜色

// see securimage.php for more options that can be set



$img->show();  // outputs the image and content headers to the browser
// 或者用下面这个，输出时设置背景图片
// $img->show('/path/to/background_image.jpg');
