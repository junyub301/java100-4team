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
        style="width:100%; height:300px; margin-bottom:-0.7rem;
        position: relative; z-index: auto;">
    </div>
    
    <!-- search bar -->    
 <nav class="c_opacity navbar navbar-dark">
 <div class="col-sm-2"></div>
  <form action=../item/list class="mx-auto form-inline col-sm-6">
    <input class="form-control mr-sm-2 col-sm-6" type="search" name='words' placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-secondary my-2 my-sm-0 col-sm-2">Search</button>
  </form>
</nav>
      <style>
      .c_opacity {
        margin-top: -44px;
       /*  background: #000000; 
        background: rgba(0, 0, 0, 0.3); */

      }
      .s_opacity {
        margin-top: -44px;
        opacity: 0.8;
      }
      
      ul{
        list-style:none;
        padding-left:0px;
        }
        .img-fluid{
        height: 225px; width: 100%; display: block;
        }
    </style>
    
    

    <!-- Grid Section -->
      <div class="container">
     
    <div class="py-4">
        
        <div class="row">
          <div class="col-md-6 col-lg-4 col-xs-12" >
            <figure class="snip1384">
            <img class="img-fluid" src="../../img/portfolio/1.jpg" alt="" />
                <figcaption>
                    <h3>CATEGORY</h3>
                    <p>category</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=1"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12">
            <figure class="snip1384">
            <img class="img-fluid" src="../../img/portfolio/2.jpg" alt="" />
                <figcaption>
                    <h3>CATEGORY</h3>
                    <p>category</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=2"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12"> 
            <figure class="snip1384">
             <img class="img-fluid" src="../../img/portfolio/3.jpg" alt="" />
                <figcaption>
                    <h3>CATEGORY</h3>
                    <p>category</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=3"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12">
          <figure class="snip1384">
           <img class="img-fluid" src="../../img/portfolio/4.jpg" alt="" />
                <figcaption>
                    <h3>CATEGORY</h3>
                    <p>category</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=4"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12" >
            <figure class="snip1384">
                <img class="img-fluid" src="../../img/portfolio/5.jpg" alt="" />
                <figcaption>
                    <h3>CATEGORY</h3>
                    <p>category</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/list?cr=5"></a>
            </figure>
          </div>
          <div class="col-md-6 col-lg-4 col-xs-12">
            <figure class="snip1384">
                <img class="img-fluid" src="../../img/portfolio/6.png" alt="" />
                <figcaption>
                    <h3>Add Item</h3>
                    <p>category</p><i class="ion-ios-arrow-right"></i>
                </figcaption>
                <a href="../item/rent"></a>
            </figure>
          </div>
        </div>
        <div class="row">
        
        </div> 
	</div>
  </div>

    <jsp:include page="../footer.jsp"/>
       
    <jsp:include page="../jslib.jsp"/>

  </body>
</html>