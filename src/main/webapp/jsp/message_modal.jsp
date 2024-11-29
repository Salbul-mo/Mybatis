<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .animation{
          animation: animatezoom 0.6s
        }

        @keyframes animatezoom {
          from {transform: scale(0);}
            to {transform: scale(1);}
        }
    </style>
</head>
<body>

<div class="container">
    <!-- The Modal -->
    <div class="modal animate" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Message</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    ${message}
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>

            </div>
        </div>
    </div>

</div>
<script>
    $("#myModal").show();

    $("[data-dismiss=modal]").click(function(event){
      // url 이 'history.back() 인 경우 뒤로가기
      if ('${url}' === 'history.back()') {
        history.back();
      } else {
        // 그렇지 않으면 url 로 이동
        location.href = '${url}';
      }
    });
</script>
</body>
</html>