/**
 * Created by jessemcgilallen on 5/12/16.
 */

function checkEntityForm(form) {
    var nameValid = checkField(form.nameField.value);
    var descriptionValid = checkField(form.descriptionField);

    return nameValid && descriptionValid;
}

function checkField(fieldValue)  {
    var regex = /^[\w]+[\w ]+[\w]+$/

    if (fieldValue == regex) {
        return true
    } else {
        return false
    }
}