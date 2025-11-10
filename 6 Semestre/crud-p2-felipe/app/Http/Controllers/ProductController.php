<?php

namespace App\Http\Controllers;

use App\Models\Product;
use Illuminate\Http\Request;
use Illuminate\Validation\Rule;

class ProductController extends Controller
{
    public function index()
    {
        $products = Product::all();
        return view('products.index', compact('products'));
    }

    public function create()
    {
        return view('products.create');
    }

    public function store(Request $request)
    {
        $validated = $request->validate(
            [
                'name' => 'required|string|unique:products|max:255',
                'price' => 'required|numeric|min:1',
                'description' => 'nullable|string',
                'quantity' => 'required|integer|min:0'
            ]
        );
        Product::create($validated);
        return redirect()->route('products.index')->with('success', 'Produto registrado com sucesso!');
    }

    public function show(Product $product)
    {
        //
    }

    public function edit(Product $product)
    {
        return view('products.edit', compact('product'));
    }

    public function update(Request $request, Product $product)
    {
        $validated = $request->validate(
            [
                'name' => ['required', 'string', 'max:255', Rule::unique('products', 'name')->ignore($product->id)],
                'price' => 'required|numeric|min:1',
                'description' => 'nullable|string',
                'quantity' => 'required|integer|min:0'
            ]
        );
        $product->update($validated);
        return redirect()->route('products.index')->with('success', 'Produto editado com sucesso!');
    }

    public function destroy(Product $product)
    {
        $product->delete();
        return redirect()->route('products.index')->with('success', 'Produto deletado com sucesso!');
    }
}
