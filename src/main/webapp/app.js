const std = document.querySelector("#std");
const tech = document.querySelector("#tech");
const std_list = document.querySelector("#std-list");
const tech_list = document.querySelector("#tech-list");


std.addEventListener("click" , ()=>{

    tech_list.classList.add("hidden");
    std_list.classList.remove("hidden");

});

tech.addEventListener("click" , ()=>{

    std_list.classList.add("hidden");
    tech_list.classList.remove("hidden");

});