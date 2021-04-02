// Squares

const ulIDES = document.querySelector("ul.IDES");


for (let i = 0; i < 20; i++) {
    const imagems = document.createElement("img");

    const random = (min,max) => Math.random() * (max - min) + min;
    
    const size = Math.floor(random(10, 120));

    const randomTrunc = Math.floor(random(1,2));

    const position = random(1,95);

    const delay = random(5,0.2);
    const duration = random(24,12);

    arrayImage = [
        "img/netbeans.png",
        "img/androidstudio.png",
        "img/eclipse.png",
        "img/intellij.png",
        "img/phpstorm.png",
        "img/xcode.png",
        "img/sublimetext.png",
        "img/pycharm.png",
        "img/sublimetext.png",
        "img/vsstudiocode.png"
    ];

    for(let value of arrayImage){
        var randomImages = Math.floor(random(0,10));
    }
    console.log(randomImages);
    let imagem = arrayImage[randomImages];

    imagems.src = `${imagem}`;
    imagems.style.width = `${size}px`;

    imagems.style.height = `${size}px`;
    imagems.style.bottom = `-${size}px`
    imagems.style.borderRadius = `50%`

    imagems.style.left = `${position}%`

    imagems.style.animationDelay = `${delay}s`;
    
    imagems.style.animationDuration = `${duration}s`;
    imagems.style.animationTimingFunction = `cubic-bezier(${Math.random(),Math.random(),Math.random(),Math.random()})`

    ulIDES.appendChild(imagems);
}

/*MODAL*/

function openModal(mn) {
    let modal = document.getElementById(mn);
    if (typeof modal == 'undefined' || modal === null)
        return;

    modal.style.display = 'Block';
    document.body.style.overflow = 'hidden';
}

function closeModal(mn) {
    let modal = document.getElementById(mn);

    if (typeof modal == 'undefined' || modal === null)
        return;

    modal.style.display = 'none';
    document.body.style.overflow = 'auto';
}

