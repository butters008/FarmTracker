<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../includes/header.jsp"/>

<main class="Animal_Dashboard_Container">
    <h2>Animal Dashboard</h2>
    <div class="Animal_Dashboard_Inside">
        <div class="Animal_Dashboard_Form">
            <h3>Animal Information</h3>
            <form>
                <div>
                    <label>Name</label>
                    <input type="Text" name="name" id="name" />
                </div>
                <div>
                    <label class="Animal_Dashboard_Form_Label">Alt Name</label>
                    <input type="Text" name="alt_name" id="alt_name" />

                </div>
                <div>
                    <label class="Animal_Dashboard_Form_Label">Type</label>
                    <select name="type" id="type">
                        <c:forEach items="${typeList}" var="type">
                            <option>${type.type_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label class="Animal_Dashboard_Form_Label">Sex</label>
                    <input type="Text" name="sex" id="sex" />                
                </div>
                <div>
                    <label class="Animal_Dashboard_Form_Label">Dead</label>
                    <input type="Text" name="dead" id="dead" />
                
                </div>
                <div>
                    <label class="Animal_Dashboard_Form_Label">Sold</label>
                    <input type="Text" name="sold" id="sold" />
                </div>
                <button type="button">Save</button>
                <!-- Going to make this button dynamic -->
                <button type="button">Delete</button>
            </form>
        <!-- This is going to be a form where you can add/edit/delete animal -->
        </div>
        <div>
            <h3>List</h3>
        <!-- This is going to be where the list will display -->
        </div>
    </div>
</main>

<jsp:include page="../includes/footer.jsp"/>