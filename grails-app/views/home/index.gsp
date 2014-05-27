<html>

<head>
	<title><g:message code="default.welcome.title" args="[meta(name:'app.name')]"/> </title>
	<meta name="layout" content="kickstart" />
</head>

<body>

	<section id="intro" class="first">
		<h1 style="text-align: center">eVote now!</h1>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<g:form controller="voting" action="vote" class="form-horizontal"  enctype="multipart/form-data">
					<fieldset class="form">
						<div class="required">
							<label for="voter" class="control-label">Voter Id<span class="required-indicator">*</span></label>
							<div>
								<g:textField class="form-control" name="voter" />
							</div>
						</div>
						<div class="required">
							<label for="party" class="control-label">Party<span class="required-indicator">*</span></label>
							<div>
								<g:select class="form-control" name="party" from="${kickstart._DemoPage$Suit?.values()}" keys="${kickstart._DemoPage$Suit.values()*.name()}" required="" value="${_DemoPageInstance?.myEnum?.name()}"/>
							</div>
						</div>
					</fieldset>
					<div class="form-actions">
						<g:submitButton name="vote" class="btn btn-primary" value="Vote!" />
					</div>
				</g:form>
			</div>
		</div>
	</section>

</body>

</html>
