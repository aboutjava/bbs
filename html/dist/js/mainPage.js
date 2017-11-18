$(function() {
    let isMobile = $(window).width() < 768;

    (function($) {
        if (isMobile) {
            $('[data-toggle="collapse"]').hover(function() {
                $(this).trigger('click');
            }, function() {

            })

            $('#navbar-collapse').hover(function() {
                // $('[data-target="#navbar-collapse"]').trigger('click');
            }, function() {
                $('[data-target="#navbar-collapse"]').trigger('click');
            })
        } else {
            $('.dropdown').hover(function() {
                $(this).addClass('open');
            }, function() {
                $(this).removeClass('open');
            });
        }

        $('.content-wrapper').on('click', function() {
            if ($('#navbar-collapse').hasClass('in')) {
                $('[data-target="#navbar-collapse"]').trigger('click');
            }
        })
    })(jQuery)
    
})