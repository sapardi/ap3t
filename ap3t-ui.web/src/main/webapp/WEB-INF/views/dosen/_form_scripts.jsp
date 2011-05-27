<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value='/resources/js/jquery.validate.min.js' var="validateUrl"/>
<c:url value='/resources/js/additional-methods.js' var="validateAddMethodUrl"/>
<script src="${validateUrl}" type="text/javascript"></script>
<script src="${validateAddMethodUrl}" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#dosenForm").validate({
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
        });
    });
</script>