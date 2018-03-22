function createRequest() {
		var request;
		try {
			request = new XMLHttpRequest();

		} catch (tryMS) {
			try {
				request = new ActiveXObject("MsXml2.XMLHTTP");
			} catch (otherMS) {
				try {
					request = new ActiveXobject("MICROSOFT.XMLHTTP");
				} catch (failed) {
					request = null;
				}
			}
		}
		return request;
	}
