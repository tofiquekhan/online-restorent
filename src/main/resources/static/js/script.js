//first request -to server to create order razor pay

const paymentStart=()=>{
    console.log("Payment STarted");
    let plan=$("#membership").val();
    console.log(plan);
    if(plan==''){
        alert("Please select membership plan")
        return;
    }

    //ajax
    $.ajax(
        {
            url : '/client/membership',
            data : JSON.stringify({plan : plan}),
            contentType: 'application/json',
            type : 'POST',
            dataType : 'json',
            success : function(response){
                console.log(response);
                if(response.status=='created'){
                    let options = {
                        key:'rzp_test_UhnY60lqwEEiCk',
                        amount : response.amount,
                        currency : 'INR',
                        name : 'Online Restro Membership',
                        order_id : response.id,
                        handler:function(response){
                            console.log(response.razorpay_payement_id);
                            console.log(response.razorpay_order_id);
                            console.log(response.razorpay_signature);
                            updatePaymentOnServer(response.razorpay_payement_id,response.razorpay_order_id,'paid');
                            
                        }
                    };
                    let rzp = new Razorpay(options);
                    
                    rzp.on('payment.failed', function (response){
                    console.log(response.error.code);
                    console.log(response.error.description);
                    console.log(response.error.source);
                    console.log(response.error.step);
                    console.log(response.error.reason);
                    console.log(response.error.metadata.order_id);
                    console.log(response.error.metadata.payment_id);
                    alert("Payment Fail");
                    });
                    rzp.open();

                }
            },
            error : function(error){
                console.log(error);
                alert("Something went wrong !!!!!");
            }
        }
    )
};




function updatePaymentOnServer(payment_id,order_id,ostatus){
    $.ajax(
        {
            url : '/client/updatePayment',
            data : JSON.stringify({payment_id  : payment_id, order_id: order_id,ostatus : ostatus}),
            contentType: 'application/json',
            type : 'POST',
            dataType : 'json',
            success : function(response){
                
                console.log('Payment Successfull');
                $('#paymentMsg').html("Success");
            },
            error : function(error){
                console.log('Payment succesfull,db not updated'); 
            }
        })
};