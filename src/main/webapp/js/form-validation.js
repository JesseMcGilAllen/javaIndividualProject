/**
 * Created by jessemcgilallen on 5/12/16.
 */

function checkTopicsForm(form) {
    var nameValid = checkField("Name", form.nameField.value);
    var descriptionValid = checkField("Description", form.descriptionField);

    return nameValid && descriptionValid;
}

function checkLanguageForm(form) {
    var nameValid = checkField("Name", form.nameField.value);

    return nameValid;
}

function checkExamples(form) {
    
}

function checkField(field, fieldValue)  {
    var regex = /^[\w]+[\w ]+[\w]+$/

    if (fieldValue == regex) {
        return true;
    } else {
        alert("Error: " + field + " cannot be Blank.");
        return false;
    }
}