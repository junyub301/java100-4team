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
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="../../css/test.css" rel="stylesheet" type="text/css">
    <!-- Plugin CSS -->
    <link href="../../vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="../../css/freelancer.min.css" rel="stylesheet">
    
</head>

  <body id="page-top">

    
    <jsp:include page="../header.jsp"/>
    
    <!-- Header -->
    <header class="masthead bg-primary2 text-white text-center" style="">
        <img class="img-fluid img-margin d-block mx-auto" src="../../img/abc.gif" style="width:100%; margin-bottom:-0.7rem; " alt="">

    </header>
    
    <!-- Search Bar -->
    
    <div class="container">
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
                        <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>검색 </button>
                    </div>
                </div>
            </div>
          </div>
        </div>
    </div>
    
    
    

    <!-- Portfolio Grid Section -->
    <section class="portfolio" id="portfolio">
      <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">정혁♥연서</h2>
        <hr class="star-dark mb-5">
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
                    <h3>Fleece Marigold</h3>
                    <p>Which is worse, that everyone has his price, or that the price is always so low.</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/rent"></a>
            </figure>
          </div>
        </div>
      </div>
    </section>

    <jsp:include page="../footer.jsp"/>
   

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-to-top d-lg-none position-fixed ">
      <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>

    <!-- Portfolio Modals -->

    <!-- Portfolio Modal 1 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="/img/portfolio/cabin.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 2 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-2">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="/img/portfolio/cake.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 3 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-3">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="/img/portfolio/circus.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 4 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-4">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="/img/portfolio/game.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 5 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-5">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="/img/portfolio/safe.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 6 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-6">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="/img/portfolio/submarine.png" alt="">
              <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close Project</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/vendor/jquery/jquery.min.js"></script>
    <!-- Plugin JavaScript -->
    <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="/js/jqBootstrapValidation.js"></script>
    <script src="/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="/js/freelancer.min.js"></script>
    
    <jsp:include page="../jslib.jsp"/>
  </body>
</html>