
gsap.from(".animateText>h2",{

    opacity:0,
    x:-20,
    duration:2,
    delay:1,
    stagger:1    /*element comes one after other */
})

// gsap.from(".page2>.cards-container",{

//    transform: "translateX(150px)",
//   stagger: 0.2, // delay between each card
//   duration:2,
// repeat:-1,
// yoyo:"true"

// })
gsap.from(".register",{
    y:1200,
    opacity:0,
    delay:0,
    duration:1
})
gsap.from(".inputFeilds",{
    x:1200,
    opacity:0,
    delay:0,
    duration:1
    //duration:0.6,
    ///stagger:1
})
