<?php

namespace App\Http\Controllers;

use App\Models\User;
use Auth;
use Hash;
use Illuminate\Http\Request;

class AuthController extends Controller
{
    public function register() {
        if(Auth::check()) {
            return redirect()->route('products.index');
        }
        return view('auth.register');
    }

    public function store(Request $request) {
        $validated = $request->validate(
            [
                'name' => 'required|string|min:3|max:30|unique:users,name',
                'email' => 'required|email|max:30|unique:users,email',
                'password' => 'required|string|min:8|max:255',
            ]
        );
        $validated['password'] = Hash::make($validated['password']);
        User::create($validated);
        return redirect()->route('auth.login')->with('success', 'Registrado com sucesso!');
    }

    public function login() {
        if(Auth::check()) {
            return redirect()->route('products.index');
        }
        return view('auth.login');
    }

    public function authenticate(Request $request) {
        $validated = $request->validate(
            [
                'email' => 'required|email|max:30',
                'password' => 'required|string|min:8|max:255',
            ]
        );
        if (Auth::attempt(['email' => $validated['email'], 'password' => $validated['password']])) {
            $request->session()->regenerate();
            return redirect()->route('products.index')->with('success', 'Login realizado com sucesso!');
        }
    }

    public function logout() {
        Auth::logout();
        return redirect()->route('auth.login');
    }
}
