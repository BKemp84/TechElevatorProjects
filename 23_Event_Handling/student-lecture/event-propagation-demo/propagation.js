let pause = 1000;

document.addEventListener('DOMContentLoaded', () => {

    document.querySelector('button').addEventListener('click', (e) => {
        e.preventDefault();
        e.stopPropagation();

        pause = document.getElementById('pause').value * 1000;

        capturePhase();
    });



});

function capturePhase() {

    document.querySelector('h1').innerText = "Capture Phase";
    document.querySelector('h1').setAttribute('class', 'textCapture');

    toggleBackground(document.querySelector('.one'), 'active-capture');
    setTimeout(function () {
        toggleBackground(document.querySelector('.two'), 'active-capture');
        setTimeout(function () {
            toggleBackground(document.querySelector('.three'), 'active-capture');
            setTimeout(function () {
                toggleBackground(document.querySelector('.four'), 'active-capture');
                setTimeout(function () {;
                    toggleBackground(document.querySelector('.five'), 'active-capture')
                    setTimeout(function () {
                        inactivateAll();
                        document.querySelector('.source').classList.remove('inactive');
                        document.querySelector('.source').classList.add('active-target');
                        document.querySelector('h1').innerText = 'Target Phase';
                        document.querySelector('h1').setAttribute('class', 'textTarget');
                        setTimeout(function () {
                            bubblePhase();
                        }, pause * 2);
                    }, pause);
                }, pause);
            }, pause);
        }, pause);
    }, pause);


    
}


function bubblePhase() {
    
    document.querySelector('h1').innerText = 'Bubble Phase';
    document.querySelector('h1').setAttribute('class', 'textBubble');
    toggleBackground(document.querySelector('.five'), 'active-bubble');
       
    setTimeout(function () {
        toggleBackground(document.querySelector('.four'), 'active-bubble');
        setTimeout(function () {
            toggleBackground(document.querySelector('.three'), 'active-bubble');
            setTimeout(function () {
                toggleBackground(document.querySelector('.two'), 'active-bubble');
                setTimeout(function () {
                    toggleBackground(document.querySelector('.one'), 'active-bubble');
                    setTimeout(function () {
                        inactivateAll();
                        document.querySelector('h1').innerHTML = '&nbsp;';
                    }, pause * 2);
                }, pause);
            }, pause);
        }, pause);
    }, pause);

}


function toggleBackground(target, activeClass) {
    
    inactivateAll();
    target.classList.remove('inactive');
    target.classList.add(activeClass);
    
}

function inactivateAll() {
    document.querySelector('button').classList.remove('active-target');
    document.querySelectorAll('div').forEach(element => {
        element.classList.remove('active-capture');
        element.classList.remove('active-bubble');
        element.classList.add('inactive');
    }); 
}



