<%@ include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title }</title>
</head>
<body>
	<div align="center">
	<h1>${episode.title}</h1>
	<iframe height="400" width="600" frameborder="0" src="${episode.link }" allowfullscreen>
	Your internet browser is not support frames
	</iframe>
	</div>
</body>
</html>