/**
 * Created by jessemcgilallen on 5/12/16.
 */

function checkTopicsForm(form) {
    var nameValid = checkField("Name", form.nameField.value);
    var descriptionValid = false;

    if (nameValid) {
        descriptionValid = checkField("Description", form.descriptionField.value);
    }

    return nameValid && descriptionValid;
}

function checkLanguageForm(form) {
    var nameValid = checkField("Name", form.nameField.value);

    return nameValid;
}

function checkExamples(form) {
    var languageValid checkField("Language", form.languageSelect.value);
    
}

function checkField(field, fieldValue)  {
    var regex = new RegExp(/^([\w]+[\w \+#]*)+$/g);

    if (regex.test(fieldValue)) {
        return true;
    } else {
        alert("Error: " + field + " cannot be Blank.");
        return false;
    }
}