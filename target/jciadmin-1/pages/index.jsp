<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>JCI | CMS</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
      rel="stylesheet" />
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
      rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
      rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<link href="./assets/css/pages/auth-light.css" rel="stylesheet" />

<script src='https://www.google.com/recaptcha/api.js'></script>

</head>

<body class="bg-silver-300">
      <div class="content">
            <div class="brand"></div>
            <form id="login-form" action="loginAction.obj" method="post">
                  <h2 class="login-title">Sign In</h2>
                  <center>
                        <img src="assets\img\logos\main_logo.png">
                  </center>
                   <span>${msg}</span>
                  <div class="form-group">
                        <div class="input-group-icon right">
                              <div class="input-icon">
                                    <i class="fa fa-envelope"></i>
                              </div>
                              <input class="form-control" type="email" name="email"
                                    placeholder="Email" autocomplete="off">
                        </div>
                  </div>
                  <div class="form-group">
                        <div class="input-group-icon right">
                              <div class="input-icon">
                                    <i class="fa fa-lock font-16"></i>
                              </div>
                              <input class="form-control" type="password" name="password"
                                    placeholder="Password">
                        </div>
                  </div>

                  <div class="form-group">
                        <div class="g-recaptcha"
                              data-sitekey="6LcrxS4pAAAAACsuVabLKpMvWvpjBJbK5Lq3ZP81"></div>
                  </div>

                  <div class="form-group">
                        <button class="btn btn-info btn-block" type="submit" id="submitBtn">Login</button>
                  </div>

            </form>
      </div>
      <!-- BEGIN PAGA BACKDROPS-->
      <div class="sidenav-backdrop backdrop"></div>
      <div class="preloader-backdrop">
            <div class="page-preloader">Loading</div>
      </div>
      <!-- END PAGA BACKDROPS-->
      <!-- CORE PLUGINS -->
      <script src="./assets/vendors/jquery/dist/jquery.min.js"
            type="text/javascript"></script>
      <script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
            type="text/javascript"></script>
      <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
            type="text/javascript"></script>
      <!-- PAGE LEVEL PLUGINS -->
      <script
            src="./assets/vendors/jquery-validation/dist/jquery.validate.min.js"
            type="text/javascript"></script>
      <!-- CORE SCRIPTS-->
      <script src="assets/js/app.js" type="text/javascript"></script>
      <!-- PAGE LEVEL SCRIPTS-->
            <script>
      $(document).on('click' , '#submitBtn' , function(){
      var response = grecaptcha.getResponse();
      
      if(response.length === 0){
            alert("Please verify you are not robot");
            return false;
      }
      
      })
      </script>
      
      <script type="text/javascript">
            $(function() {
                  $('#login-form').validate({
                        errorClass : "help-block",
                        rules : {
                              email : {
                                    required : true,
                                    email : true
                              },
                              password : {
                                    required : true
                              }
                        },
                        highlight : function(e) {
                              $(e).closest(".form-group").addClass("has-error")
                        },
                        unhighlight : function(e) {
                              $(e).closest(".form-group").removeClass("has-error")
                        },
                  });
            });
      </script>
</body>

</html>

