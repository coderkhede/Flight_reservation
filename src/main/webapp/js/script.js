/**
 * 
 */
// Wait for the DOM to be fully loaded before running any JavaScript
document.addEventListener('DOMContentLoaded', function() {
    // Function to handle navigation menu dropdown on mobile screens
    const toggleNavMenu = () => {
        const navToggle = document.getElementById('nav-toggle');
        const navMenu = document.getElementById('nav-menu');

        navToggle.addEventListener('click', () => {
            navMenu.classList.toggle('show-menu');
        });

        // Close menu when a link is clicked (for smoother navigation)
        const navLinks = navMenu.querySelectorAll('a');
        navLinks.forEach(link => {
            link.addEventListener('click', () => {
                navMenu.classList.remove('show-menu');
            });
        });
    };

    // Function to initialize sliders (if any)
    const initializeSliders = () => {
        // Example: Implement an image slider
        // Replace '.slider-container' and '.slide' with your actual slider classes/IDs
        const slides = document.querySelectorAll('.slide');
        let slideIndex = 0;

        const showSlide = (index) => {
            slides.forEach(slide => slide.style.display = 'none');
            slides[index].style.display = 'block';
        };

        const nextSlide = () => {
            slideIndex++;
            if (slideIndex >= slides.length) {
                slideIndex = 0;
            }
            showSlide(slideIndex);
        };

        // Auto play the slides every 5 seconds
        setInterval(nextSlide, 5000);
    };

    // Call functions to initialize components when the DOM is loaded
    toggleNavMenu();
    initializeSliders();
});