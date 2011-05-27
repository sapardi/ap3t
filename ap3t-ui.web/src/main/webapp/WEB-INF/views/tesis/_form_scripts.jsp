<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value='/resources/js/jquery.validate.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/additional-methods.js' />" type="text/javascript"></script>
<link href="<c:url value='/resources/css/smoothness/jquery-ui-1.8.13.custom.css'/>" type="text/css" rel="stylesheet"/>
<link href="<c:url value='/resources/css/smoothness/jquery-ui-timepicker-addon.css'/>" type="text/css" rel="stylesheet"/>
<script src="<c:url value='/resources/js/jquery-ui-1.8.13.custom.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/jquery-ui-timepicker-addon.js'/>" type="text/javascript"></script>


<script type="text/javascript">
    $(document).ready(function() {
        /*  $("#topikForm").validate({
         */
        /* rules: {
         opened: {
         required: true,
         dateTime: true
         }
         },
         messages: {
         opened: {
         required: " Required"
         }
         }*/
        /*
         });*/

        $("#jadwalUjian").datetimepicker({'dateFormat':'dd-mm-yy'});
    });


</script>