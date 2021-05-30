$(document).ready(function(){
    console.log("document is ready")

    var rowIdx = 1;

    $('#addBtn').on('click' , function(){
        console.log("button clicked")

        $('#tBody').append(`

            <tr id="R${++rowIdx}">
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="First Name"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Last name"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Status"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Relation with head"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Gender"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Date of Birth"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Age"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Family Gotra"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Mother Gotra"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Education"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Occupation"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Marital Status"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Special Ability" ></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="input-group input-group-md"> <input type="text" class="form-control" placeholder="Mobile Number"></div>
                        </td>
                        <!-- ----------------------------------------------------------------------------------- -->
                        <td>
                            <div class="mb-3">
                                <input class="form-control form-control-sm" id="formFileSm" type="file">
                            </div>
                        </td>
                       
                        <!-- ----------------------------------------------------------------------------------- -->
                       
                        <td>
                            <div class="text-center">
                                <img src="C:\\Users\\Palash\\IdeaProjects\\ProjectNanuram\\icons8-remove-46.png" class="removeIcon" id="rmvBtn" alt="addIcon"/>
                            </div>
                        </td>

                    </tr>`
        );

    });

    $('#tBody').on('click' , '#rmvBtn' , function(){

        var child = $(this).closest('tr').nextAll();
        child.each(function(){

            var id = $(this).attr('id');
            var dig = parseInt(id.substring(1));
            $(this).attr('id' , `R${dig-1}`);
        });

        $(this).closest('tr').remove();

        rowIdx--;

    });





});


