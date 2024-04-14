<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../includes/header.jsp"/>

<%-- TODO: Move all CSS into Stylesheets when done --%>
<style>

.typeList{
    display:flex;
    flex-direction: column;
}

.typeList_ForLoop{
    display:flex;
    flex-direction: row;
}
.typeList_ForLoop section{
    padding-left: 3px;
}
</style>

<main>
    <h2>Systems Dashboard</h2>
    <div class="typeList">
        <h3>Types of Animals</h3>
        <div>
        <c:forEach items="${typesList}" var="type">
            <div class="typeList_ForLoop">
                <section>${type.type_id}</section>
                <section>${type.type_name}</section>
            </div>
        </c:forEach>
        <form id="form_add_new_type" name="form_add_new_type" action="/systems/add_new_type" method="post">
            <input type="text" name="type_id" id="type_id">
            <input type="text" name="type_name" id="type_name">
            <button type="submit" id="type_button_submit">Submit</button>
        </form>
        </div>        
    </div>
</main>

<jsp:include page="../includes/footer.jsp"/>