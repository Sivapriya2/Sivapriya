function updatePageNumber() {
    const pageNumber = document.getElementById("pageRange").value;
    document.getElementById("pageNumber").textContent = pageNumber;
  }

  function submitButton() {
    const form = document.getElementById('myForm');
    const submitButton = document.getElementById('submitButton');
    submitButton.addEventListener('click', function() {
      form.submit();
    });
  };
  
  function clearForm(){
    const clearButton = document.getElementById('clearButton');
    clearButton.addEventListener('click', clearForm);
  }