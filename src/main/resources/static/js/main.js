$("#addUser").on('click', () => {
    let array = []
    let options = document.querySelector('#selectedRoles').options
    for (let i = 0; i < options.length; i++) {
        if (options[i].selected) {
            let role = {id: options[i].value, name: options[i].text}
            array.push(role)
        }
    }
    $.ajax({
        url: 'http://localhost:8088/api/admin',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify({
            name: $('#name').val(),
            lastName: $('#lastName').val(),
            nickname: $('#nickname').val(),
            birthDate: $('#birthDate').val(),
            country : $('#country').val(),
            details : $('#details').val(),
            mail : $('#mail').val(),
            password: $('#password').val(),
            roles: array
        }),
        success: function () {
            $('#listUsers').empty();
            getAllUsers();
            $('#nav-home-tab').tab('show');
        },
        error: function () {
            alert('error addUser')
        }
    });
    const { myForm } = document.forms;
    myForm.reset();
});

async function popular_publication() {
    await fetch("http://localhost:8088/api/allPublications")
        .then(res => res.json())
        .then(items => {
            let logs = ``;
            items.forEach((i) => {
                logs += `<div class="item-div">
                         <a href="/blog/posts/${i.id}"><img src="data:image/png;base64,${i.publicationImage}"></a>
                         <h6>${i.header}</h6>
                         <h6>${i.theme}</h6>
                         <p>${i.date}</p>
                         <a class="text-decoration-none text-muted" id ="${i.id}" href="/blog/posts/${i.id}">Читать дальше</a><br>
                         </div>`;
            })
            document.querySelector('.item-container').innerHTML = logs;
        })
}
popular_publication();

async function findPosts() {
    const searchInput = document.getElementById('searchMainPageInput');
    console.log(searchInput.value);
    $(document.getElementById('searchHomePageButton')).on('click', async function () {
        await fetch("http://localhost:8088/api/allPublications")
            .then(res => res.json())
            .then(items => {
                document.querySelector('.item-container').innerHTML = search(items, searchInput);
            })
    })
}

findPosts();