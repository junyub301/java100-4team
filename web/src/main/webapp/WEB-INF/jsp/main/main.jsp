<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SHARE</title>
    
    <!-- Bootstrap core CSS -->
   <!--  <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/freelancer.min.css" rel="stylesheet">
    <link href="../../css/test.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    
     -->
</head>

  <body id="page-top">

    
    <jsp:include page="../header.jsp"/>
    
    <!-- Header -->
    <div>
        <img class="" src="../../img/portfolio/isCAhgO.jpg" 
        style="width:100%; height:550px; margin-bottom:-0.7rem;
        position: relative; z-index: auto;">
    </div>
    
    <!-- search bar -->    
 <nav class="c_opacity navbar navbar-dark">
 <div class="col-sm-2"></div>
  <form action=../item/list class="mx-auto form-inline col-sm-6">
    <input class="form-control mr-sm-2 col-sm-6" type="search" name='words' placeholder="Search" aria-label="Search">
   
    <button class="btn btn-outline-secondary my-2 my-sm-0">Search</button>
  </form>
</nav>
      <style>
      .c_opacity {
        margin-top: -44px;
        background: #000000; 
        background: rgba(0, 0, 0, 0.3);

      }
      .s_opacity {
        margin-top: -44px;
        opacity: 0.8;
      }
    </style>
    
    

    <!-- Portfolio Grid Section -->
    <section class="" id="portfolio">
      <div class="container">
        <!-- <h2 class="text-center text-uppercase text-secondary mb-0">정혁♥연서</h2> -->
        <!-- <hr class="star-dark mb-5"> -->
        <div class="row">
          <div class="col-md-6 col-lg-4 col-xs-12" >
            <figure class="snip1384">
            <img class="" src="../../img/portfolio/cabin.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=1"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12">
            <figure class="snip1384">
            <img class="" src="../../img/portfolio/cake.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=2"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12">
            <figure class="snip1384">
             <img class="" src="../../img/portfolio/circus.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=3"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12">
          <figure class="snip1384">
           <img class="" src="../../img/portfolio/game.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=4"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12" >
            <figure class="snip1384">
                <img class="" src="../../img/portfolio/safe.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=5"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12">
            <figure class="snip1384">
                <img class="" src="../../img/portfolio/submarine.png" alt="" />
                <figcaption>
                    <h3>Add Item</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/rent"></a>
            </figure>
          </div>
        </div>
      </div>
    </section>

    <jsp:include page="../footer.jsp"/>
       
    <jsp:include page="../jslib.jsp"/>
<!-- <script type="text/javascript">

    $('#rent').click(function(){
        $('#conts').css('display', 'none');
        });

</script> -->
    
    
  </body>
</html>