<template>
<div class="off-canvas-wrapper">
<div class="off-canvas-wrapper-inner" data-off-canvas-wrapper>
    <div class="off-canvas position-left" id="offCanvasLeft" data-off-canvas>
        <ul class="vertical menu">
            <li><a href="#">Menu Foo</a></li>
            <hr/>
            <li><a href="#">Menu Item 1</a></li>
            <li><a href="#">Menu Item 2</a></li>
        </ul>
    </div>
    <div class="off-canvas-content" data-off-canvas-content>
        <div class="content">
            <div class="title-bar no-print" style="width:100%;">
                <div class="title-bar-left hide-for-medium" style="width: 100%;">
                    <div class="title-bar-title text-center" style="width: 100%;">
                        <div class="row">
                            <div class="small-1 column position-left">
                                <button data-responsive-toggle="responsive-menu" class="menu-icon position-left" type="button" data-toggle="offCanvasLeft" style="padding:0;"></button>
                            </div>
                            <div class="small-10 column end">
                                <button data-open="exampleModal1" class="secondary hollow button small" style="width:80%;" >
                                    Where to?
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="responsive-menu" >
                    <div class="top-bar-title">
                        <img src="http://placehold.it/80x38/f3a3fe/000000?text=Brand+Icon" alt="Brand Icon">
                    </div>

                    <div class="top-bar-left" style="width:50%;">
                        <ul class="horizontal menu">
                            <input type="text" class="" placeholder="Where to?" style="color:white;background: url('images/turn_page20.png') no-repeat left 10px center;padding-left:45px;border:0;" />
                        </ul>
                    </div>

                    <div class="top-bar-right">
                        <ul class="horizontal menu">
                            <li><a href="#">Sign Up</a></li>
                            <li><a href="#">Login</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="reveal large text-center" id="exampleModal1" data-reveal>
                Search
                <p><input type="text" placeholder="Where to?" /></p>
                <p><input type="submit" value="Submit" /></p>
                <button class="close-button" data-close aria-label="Close modal" type="button">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="column row">
                Body content here.
            </div>
        </div><!-- end content -->
    </div><!-- end of off-canvas content -->
</div><!-- end off-canvas-wrapper-inner -->
</div>
</template>