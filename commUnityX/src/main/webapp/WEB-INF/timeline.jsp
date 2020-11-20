<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/timeline.css">
<title>Login</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg navbar-body">
		<a class="navbar-brand" href="/timeline"> <img
			src="https://www.kenan-asia.org/wp-content/uploads/2017/03/Partnership-csr.jpg"
			alt="Logo" class="logo">
		</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/profle/id">Profile</a></li>
			<li class="nav-item"><a class="nav-link" href="/create">Create Event</a></li>

			<li class="nav-item"><a class="nav-link" href="/messages/id">Messages</a></li>
			<li class="nav-item"><a class="nav-link" href="/all events">Events</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="/settings" id="navbardrop"
				data-toggle="dropdown"> Settings</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/edit_profile/id">Edit Profile</a> <a
						class="dropdown-item" href="/privacy_blocking/id">Privacy&Blocking</a>
					<a class="dropdown-item" href="/logout">logout</a>
				</div></li>
		</ul>
		<form class="form-inline" action="/action_page.php">
			<input class="form-control mr-sm-2" type="text">
			<button class="btn btn-primary" type="submit">Search</button>
		</form>
	</nav>
	<div class="seperator"></div>
	<div class="jumbotron jumbotron-fluid">
		<div class="jumbo_content">
			<h1></h1>
		</div>
	</div>
	<div class="posts">
		<div class="col-lg-6 col-md-4 col-sm-6 mb-4">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Six</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Itaque earum nostrum suscipit ducimus nihil
						provident, perferendis rem illo, voluptate atque, sit eius in
						voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
				</div>
			</div>
		</div>
		<div class="row bootstrap snippets">
			<div class="col-md-6 col-md-offset-2 col-sm-12">
				<div class="comment-wrapper">
					<div class="panel panel-info">
						<div class="panel-heading">Comment panel</div>
						<div class="panel-body">
							<textarea class="form-control" placeholder="write a comment..."
								rows="3"></textarea>
							<br>
							<button type="button" class="btn btn-info pull-right">Post</button>
							<div class="clearfix"></div>
							<hr>
							<ul class="media-list">
								<li class="media"><a href="#" class="pull-left"> <img
										src="https://bootdey.com/img/Content/user_1.jpg" alt=""
										class="img-circle">
								</a>
									<div class="media-body">
										<span class="text-muted pull-right"> <small
											class="text-muted">30 min ago</small>
										</span> <strong class="text-success">@MartinoMont</strong>
										<p>
											Lorem ipsum dolor sit amet, consectetur adipiscing elit.
											Lorem ipsum dolor sit amet, <a href="#">#consecteturadipiscing
											</a>.
										</p>
									</div></li>
								<li class="media"><a href="#" class="pull-left"> <img
										src="https://bootdey.com/img/Content/user_2.jpg" alt=""
										class="img-circle">
								</a>
									<div class="media-body">
										<span class="text-muted pull-right"> <small
											class="text-muted">30 min ago</small>
										</span> <strong class="text-success">@LaurenceCorreil</strong>
										<p>
											Lorem ipsum dolor sit amet, consectetur adipiscing elit.
											Lorem ipsum dolor <a href="#">#ipsumdolor </a>adipiscing
											elit.
										</p>
									</div></li>
								<li class="media"><a href="#" class="pull-left"> <img
										src="https://bootdey.com/img/Content/user_3.jpg" alt=""
										class="img-circle">
								</a>
									<div class="media-body">
										<span class="text-muted pull-right"> <small
											class="text-muted">30 min ago</small>
										</span> <strong class="text-success">@JohnNida</strong>
										<p>
											Lorem ipsum dolor <a href="#">#sitamet</a> sit amet,
											consectetur adipiscing elit.
										</p>
									</div></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>