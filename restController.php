<?php 
	//ThreadController
	public function api_endpoint_create(Request $request) {
        $name = $request->input('name');
        $email = $request->input('email');
        $password = $request->input('password');

        $collect = [
            'User'=>[
                'username'=> $name,
                'email'=> $email,
                'password'=> $password
            ],
            'Receiver'=>'Ocean',
            'Access'=>'Admin'
        ];
        return response()->json($collect, 200);
    }


//Route
Route::post('/api_make_user', 'ThreadController@api_endpoint_create');

?>