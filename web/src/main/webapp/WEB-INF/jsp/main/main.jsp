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
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/freelancer.min.css" rel="stylesheet">
    <link href="../../css/test.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    
    
</head>

  <body id="page-top">

    
    <jsp:include page="../header.jsp"/>
    
    <!-- Header -->
    <header class="masthead bg-primary2 text-white text-center" style="">
    <div style="position: relative; top: -80px;">
        <img class="img-fluid img-margin d-block mx-auto" src="../../img/portfolio/isCAhgO.jpg" style="width:100%; height:650px; margin-bottom:-0.7rem; " alt="">
    </div>

    </header>
    
    <!-- Search Bar -->
    
    <div style="position: relative; opacity:0.5; top: -145px;" class="navbar navbar-expand-lg bg-secondary text-uppercase" id="mainNav">
      <div style="margin-left:50px; display: inline-block;">
        <a style="opacity: 0;" class="navbar-brand js-scroll-trigger" href="./main">Sharer  Sharee</a>
        
      </div>
    </div>
    
    <div style="position: relative; top: -195px;" class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="input-group" id="adv-search">
                <input type="text" class="form-control" placeholder="검색어를 입력하세요" />
                <div class="input-group-btn">
                    <div class="btn-group" role="group">
                        <div class="dropdown dropdown-lg">
                            <button style="width: 50px;" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                            <div class="dropdown-menu dropdown-menu-right" role="menu">
                                <form class="form-horizontal" role="form">
                                  <div class="form-group">
                                    <label for="filter">Filter by</label>
                                    <select class="form-control">
                                        <option value="0" selected>빌려주세요</option>
                                        <option value="1">빌려드립니다</option>
                                    </select>
                                  </div>
                                  <div class="form-group">
                                    <label for="contain">단어 포함</label>
                                    <input class="form-control" type="text" />
                                  </div>
                                  <div class="form-group">
                                    <label for="contain">단어 포함</label>
                                    <input class="form-control" type="text" />
                                  </div>
                                  <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>검색</button>
                                </form>
                            </div>
                        </div>
                        <button onclick="location.href='../item/list'" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>검색 </button>
                    </div>
                </div>
            </div>
          </div>
        </div>
    </div>

    <!-- Portfolio Grid Section -->
    <section class="portfolio" id="portfolio">
      <div id="conts" class="container">
        <!-- <h2 class="text-center text-uppercase text-secondary mb-0">정혁♥연서</h2> -->
        <!-- <hr class="star-dark mb-5"> -->
        <div class="row">
          <div class="col-md-6 col-lg-4" >
            <figure class="snip1384">
            <img class="img-fluid" src="../../img/portfolio/cabin.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../user/list"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4">
            <figure class="snip1384">
            <img class="img-fluid" src="../../img/portfolio/cake.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../user/list"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4">
            <figure class="snip1384">
             <img class="img-fluid" src="../../img/portfolio/circus.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../user/list"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4">
          <figure class="snip1384">
           <img class="img-fluid" src="../../img/portfolio/game.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../user/list"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4">
            <figure class="snip1384">
                <img class="img-fluid" src="../../img/portfolio/safe.png" alt="" />
                <figcaption>
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../user/list"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4">
            <figure class="snip1384">
                <img class="img-fluid" src="../../img/portfolio/submarine.png" alt="" />
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