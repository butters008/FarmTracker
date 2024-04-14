<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../includes/header.jsp"/>
<main>
    <h2>Systems Dashboard</h2>
    <div>
        <h3>Types of Animals</h3>
        <c:forEach items="${TypeList}" var="type">
            <div>${type}</div>
        </c:forEach>
        <form id="form_add_new_type" name="form_add_new_type" action="/systems/add_new_type" method="post">
            <input type="text" name="type_id" id="type_id">
            <input type="text" name="type_name" id="type_name">
            <button type="submit" id="type_button_submit">Submit</button>
        </form>
    </div>
</main>

<jsp:include page="../includes/footer.jsp"/>