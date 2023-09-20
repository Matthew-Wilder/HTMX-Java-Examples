function getQueryParameters() {
    const queryString = window.location.search;
    return new URLSearchParams(queryString);
}

document.body.addEventListener("foobar123", function(evt){
    console.log(evt);
    const personId = parseInt(evt.detail.elt.dataset.id);
    console.log(personId);
    const observers = $("[hx-trigger^='foobar123']");
    observers.each(function() {
        const self = $(this);
        const original = self.attr("hx-get");
        self.attr("hx-get", `${original}?id=${personId}`)
    })
    console.log(observers);
})
