<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="false"%>
<html>

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>Dreamy Diary!</title>

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">

	<!-- FullCalendar CSS -->
	<link href="<c:url value='/css/fullcalendar/fullcalendar.css'/>" rel='stylesheet' />
	<link href="<c:url value='/css/fullcalendar/daygrid.css'/>" rel='stylesheet' />
	<link href="<c:url value='/css/fullcalendar/timegrid.css'/>" rel='stylesheet' />

	<!-- FullCalendar JS -->
	<script src="<c:url value='/js/fullcalendar/fullcalendar.js'/>"></script>
	<script src="<c:url value='/js/fullcalendar/daygrid.js'/>"></script>
	<script src="<c:url value='/js/fullcalendar/timegrid.js'/>"></script>
	<script src="<c:url value='/js/fullcalendar/interaction.js'/>"></script>

	<script type="text/javascript">
		document.addEventListener('DOMContentLoaded', function () {
			var calendarEl = document.getElementById('calendar');

			var calendar = new FullCalendar.Calendar(calendarEl, {
				plugins: ['dayGrid', 'timeGrid', 'interaction'],
				defaultView: 'dayGridMonth',
				defaultDate: new Date(),
				locale: 'ko',
				header: {
					left: 'prevYear,prev,next,nextYear today',
					center: 'title',
					right: 'dayGridMonth' // + dayGridWeek,dayGridDay
				},
				editable: true,
				eventLimit: true,
				navLinks: true, // can click day/week names to navigate views
		        selectable: true,
		        selectMirror: true,
		        select: function(arg) {
		        	var target = document.getElementById("select-menu");
		        	if(target.options[target.selectedIndex].value == "Title"){
				        var title = document.getElementById("title-txt").value;
				        if (title) {
				        	calendar.addEvent({
				            title: title,
				            start: arg.start,
				            end: arg.end,
				            allDay: arg.allDay
				          })
				        }
				        calendar.unselect();
				        document.getElementById("title-txt").value = "";
				        //console.log(calendar.getEventSources());
				        //console.log(calendar.getEvents().start);
				        //console.log(calendar.getEvents().end);
		        	}
		        },
				events: [

				],
				dateClick: function (info) {
// 					console.log('Clicked on: ' + info.dateStr);
// 					console.log('Coordinates: ' + info.jsEvent.pageX + ','
// 						+ info.jsEvent.pageY);
// 					console.log('Current view: ' + info.view.type);
					// change the day's background color just for fun
					// 				info.dayEl.style.backgroundColor = document
					// 						.getElementById("color-select").value;

					//var src = "<c:url value='/images/cute-dog.jpg'/>";
					var target = document.getElementById("select-menu");

					//console.log(target.options[target.selectedIndex].value);
					if(target.options[target.selectedIndex].value == "Color"){
						info.dayEl.style.backgroundColor = document
											.getElementById("color-select").value;
					}else if(target.options[target.selectedIndex].value == "Image"){
						var imageUrl = document.getElementById("image-url").value;
						var url = "url(\'" + imageUrl + "\')"
						//console.log(url);
						//info.dayEl.style.backgroundImage = "url('https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F24283C3858F778CA2EFABE')";
						info.dayEl.style.backgroundImage = url;
						info.dayEl.style.backgroundRepeat = "noRepeat";
						info.dayEl.style.backgroundSize = "cover";
					}
					//console.log(src);
					//info.dayEl.style.backgroundImage = "url('https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F24283C3858F778CA2EFABE')";
					//console.log(document.getElementById("color-select").value);
				}
// 				eventSources: [
// 					// your event source
// 					{
// 						events: function (fetchInfo, successCallback, failureCallback) {
// 							// ...
// 						},
// 						color: 'yellow', // an option!
// 						textColor: 'black' // an option!
// 					}
// 					// any other sources...
// 				]
			});
			calendar.render();
			
			var saveEvents = document.getElementById("save-event");
			saveEvents.onclick = function(){
				//console.log(typeof calendar.getEvents());
// 				console.log(calendar.getEvents()[0].start);
				console.log("data transfer click!");
				console.log(calendar.getEvents().length);

				var eventObj = [];
				for(var i=0; i<calendar.getEvents().length; ++i){
					eventObj[i] = {
							title : calendar.getEvents()[0].title,
							start : calendar.getEvents()[0].start,
							end : calendar.getEvents()[0].end
					}
					
 					//console.log(typeof eventObj[i].start);
					
				    $.ajax({
				        url: "<c:url value='/events'/>",
				        type: "post",
				        data: JSON.stringify(eventObj[i]),
				        dataType: "json",
				        contentType: "application/json",
				        success: function(data) {
				            console.log("data transfer success");
				        },
				        error: function(errorThrown) {
				            console.log(errorThrown.statusText);
				            //console.log("data transfer fail");
				        }
				    });
				}
			};
			
			var getEvents = document.getElementById("get-event");
			getEvents.onclick = function(){
				 $.ajax({
				        url: "<c:url value='/getevents'/>",
				        dataType: "json",
				        type: "post",
				        success: function(data) {
				        	for(var i=0; i<data.length; ++i){
				        		calendar.addEvent(data[i]);
				        	}
				        },
				        error:function() {
				            console.log("error");
				        }
				    });
			}
		});
	</script>
</head>

<body>
	<nav class="navbar fixed-top navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
		<a class="navbar-brand" href="#">MenuBar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item">Title <input type="text" id="title-txt"></li>
				<li class="nav-item">Color <input type="color" id="color-select" value="#FFFFFF"></li>
				<li class="nav-item">Image <input type="text" id="image-url"></li>
				<li class="nav-item">Select Menu
					<select id="select-menu">
						<option value="Title">Title</option>
						<option value="Color">Color</option>
						<option value="Image">Image</option>
					</select>
				</li>	
				<li class="nav-item">
					<button class="btn btn-outline-success my-2 my-sm-0" type="button" id="save-event">Save</button>
				</li>
				<li class="nav-item">
					<button class="btn btn-outline-success my-2 my-sm-0" type="button" id="get-event">Load</button>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<br />
	<br />
	<br />
	<div class="container">
		<div id="calendar"></div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value='/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/js/popper.min.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>

</body>

</html>