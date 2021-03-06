<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>OPTIGRAM</title>
	<!-- CSS -->
    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="resources/bootstrap/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <!-- Theme CSS -->
    <link href="resources/bootstrap/css/creative.min.css" rel="stylesheet">
	<!-- Box slider -->
	<link href="resources/jquery/bxslider/jquery.bxslider.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style>
		#developer{
			font-size : 28px;
			text-align : center;
			font-style : italic;
		}
		MARQUEE{
			width : 300px;
			text-align : center;
		}
	</style>
</head>

<body id="page-top">

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Optimization Programming</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#homeHeading">about</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#game">game</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#optibot">optibot</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#next">next</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading">Optimization Programming</h1>
                <hr>
                <p>Make With</p>
                <div id="developer">
	                <MARQUEE direction=up height=55 behavior=alternate scrollamount=1>Gyucheol Im</MARQUEE>
	                <MARQUEE direction=down height=55 behavior=alternate scrollamount=1>Kisung Lee</MARQUEE>
	                <MARQUEE direction=up height=55 behavior=alternate scrollamount=1>Ikhyeon Cho</MARQUEE>
                </div>
                <hr>
                <p>Our Project</p>
                
                <div class="row">
                	<div class="col-lg-6 col-md-6 text-center">
		                <div class="service-box">
		                    <i class="fa fa-5x fa-gamepad text-primary sr-icons"></i><br/>
		                    <a href="#game" class="btn btn-primary btn-xl page-scroll">GAME</a>
		                    <p class="text-muted">스도쿠<br/>
		                        					   붕어빵타이쿤<br/>
		                        					   지뢰찾기</p>
		                </div>
		            </div>
		            <div class="col-lg-6 col-md-6 text-center">
		                <div class="service-box">
		                    <i class="fa fa-4x fa-wechat text-primary sr-icons"></i><br/>
		                 	<a href="#optibot" class="btn btn-primary btn-xl page-scroll">CHATBOT</a>
		                    <p class="text-muted">OPTIBOT<br/><br/></p>
		                </div>
	                </div>
                </div>
                
            </div>
        </div>
    </header>

    <section id="game">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Game Project</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row">
                <div class="col-lg-4 text-center">
					<h3>지뢰찾기</h3>	               
	                <ul class="bxslider">
						<li><img src="resources/game/ams/imgs/ams_img01.png" title="사각형" /></li>
						<li><img src="resources/game/ams/imgs/ams_img02.png" title="폭탄" /></li>
						<li><img src="resources/game/ams/imgs/ams_img03.png" title="별" /></li>
						<li><img src="resources/game/ams/imgs/ams_img04.png" title="피라미드" /></li>
					</ul>
                </div>
                <div class="col-lg-4 col-md-6 text-center">
                    <div class="service-box">
                        <h3>우리집 어항</h3>
                        <img src="http://211.226.233.246:8080/?action=stream" width="100%" height="100%"/>
                    </div>
                </div>
           </div>
           <div class="row">
                <div class="col-md-12 text-center">
                        <h3>지렁이</h3>
                        <iframe width="100%" height="600px" src="http://slither.io/"></iframe>
                </div>
            </div>
        </div>
    </section>

	<section class="bg-primary" id="optibot">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 text-center">
					<h2 class="section-heading">OPTIBOT!</h2>
                    <hr class="light">
                    <p class="text-faded">More powerful chatbot project</p>
                    <p><a href="optibot" class="page-scroll btn btn-default btn-xl sr-button">More detail</a></p>
                </div>
                
                <div class="col-lg-8 text-center">
					<iframe class="col-lg-12" src="optibot" style="height:640px" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </section>
    
    <section class="no-padding" id="portfolio">
        <div class="container-fluid">
            <div class="row no-gutter popup-gallery">
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/1.jpg" class="portfolio-box">
                        <img src="resources/bootstrap/img/portfolio/thumbnails/1.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Java A to Z
                                </div>
                                <div class="project-name">
                                    JAVA
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/2.jpg" class="portfolio-box">
                        <img src="resources/bootstrap/img/portfolio/thumbnails/2.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/3.jpg" class="portfolio-box">
                        <img src="resources/bootstrap/img/portfolio/thumbnails/3.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/4.jpg" class="portfolio-box">
                        <img src="resources/bootstrap/img/portfolio/thumbnails/4.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/5.jpg" class="portfolio-box">
                        <img src="resources/bootstrap/img/portfolio/thumbnails/5.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/6.jpg" class="portfolio-box">
                        <img src="resources/bootstrap/img/portfolio/thumbnails/6.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>

    <aside class="bg-dark">
        <div class="container text-center">
            <div class="call-to-action">
                <h2>Free Download at Start Bootstrap!</h2>
                <a href="http://startbootstrap.com/template-overviews/creative/" class="btn btn-default btn-xl sr-button">Download Now!</a>
            </div>
        </div>
    </aside>

    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Let's Get In Touch!</h2>
                    <hr class="primary">
                    <p>Ready to start your next project with us? That's great! Give us a call or send us an email and we will get back to you as soon as possible!</p>
                </div>
                <div class="col-lg-4 col-lg-offset-2 text-center">
                    <i class="fa fa-phone fa-3x sr-contact"></i>
                    <p>123-456-6789</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="fa fa-envelope-o fa-3x sr-contact"></i>
                    <p><a href="mailto:your-email@your-domain.com">feedback@startbootstrap.com</a></p>
                </div>
            </div>
        </div>
    </section>
    
    
	<!-- JS -->
	<!-- jQuery -->
	<script src="resources/bootstrap/vendor/jquery/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
    <script src="resources/bootstrap/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="resources/bootstrap/vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="resources/bootstrap/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
    <!-- Theme JavaScript -->
    <script src="resources/bootstrap/js/creative.min.js"></script>
	<!-- Box slider JavaScript -->
	<script src="resources/jquery/bxslider/jquery.bxslider.min.js"></script>
	<script>
		$(document).ready(function() {
			var fontColor = ['red','orange','yellow','green','blue','navy','purple'];
			var i=0;
			$('.bxslider').bxSlider({
				mode : 'fade',
				captions : true,
				speed:500,
				auto:true
			});
			setInterval(function(){
				i++;
				$('#developer MARQUEE').animate({
					'opacity' : '0.4'
				},1000);
				$('#developer  MARQUEE').animate({
					'opacity' : '1'
				},2000).css('color',fontColor[i%7]);
			},3000);
		});
	</script>
  	
</body>

</html>
