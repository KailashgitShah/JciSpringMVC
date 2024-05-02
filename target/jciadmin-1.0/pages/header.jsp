<header class="header">
            <div class="page-brand">
                <a class="link" href="#">
                    <span class="brand"> 
                        <span class="brand-tip">JCI Admin</span>
                    </span>
                    <span class="brand-mini">JCI</span>
                </a>
            </div>
            <div class="flexbox flex-1">
                <!-- START TOP-LEFT TOOLBAR-->
                <ul class="nav navbar-toolbar">
                    <li>
                        <a class="nav-link sidebar-toggler js-sidebar-toggler"><i class="ti-menu"></i></a>
                    </li>
                    
                </ul>
                <!-- END TOP-LEFT TOOLBAR-->
                <!-- START TOP-RIGHT TOOLBAR-->
                <ul class="nav navbar-toolbar">
                    
                     
                    <li class="dropdown dropdown-user">
                        <a class="nav-link dropdown-toggle link" data-toggle="dropdown">
                            <img src="./assets/img/admin-avatar.png" />
                             <% String name =(String)request.getSession().getAttribute("rolename");
                             /* try{
                             int refid =(int)request.getSession().getAttribute("refId");
                             }
                             catch(Exception e){
                            	 int refid=0;
                             } */%>
                            <span></span><%out.println(name);%><i class="fa fa-angle-down m-l-5"></i></a>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="userProfile.obj"><i class="fa fa-user"></i>Profile</a>
                            
                            <li class="dropdown-divider"></li>
                            <!-- <a class="dropdown-item" href="index.obj"><i class="fa fa-power-off"></i>Logout</a> -->
                             <a class="dropdown-item" href="index.obj"><i class="fa fa-power-off"></i>Logout</a>
                        </ul>
                    </li>
                </ul>
                <!-- END TOP-RIGHT TOOLBAR-->
            </div>
        </header>