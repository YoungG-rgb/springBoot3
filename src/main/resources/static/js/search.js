function search(items, searchInput) {
    let logs = ``;
    let isEmpty = true;
    items.forEach((i) => {
        if (i.header.toLowerCase().includes(searchInput.value.toLowerCase()) || searchInput.value === '') {
            isEmpty = false;
            logs += `<div class="item-div">
                         <a href="/blog/posts/${i.id}"><img src="data:image/png;base64,${i.publicationImage}"></a>
                         <h6>${i.header}</h6>
                         <h6>${i.theme}</h6>
                         <p>${i.date}</p>
                         <a class="text-decoration-none text-muted" id ="${i.id}" href="/blog/posts/${i.id}">Читать дальше</a><br>
                         </div>`;
        }
    })

    // Проверка что нету предметов
    if (isEmpty) {
        logs += `<h4>Ничего не найдено</h4>`
    }
    return logs;
}