<script>
  import '../app.css';
  import Header from '../lib/layouts/Header.svelte';
</script>

<div class="min-h-screen flex flex-col justify-between">
	<Header />

	<main class="mx-16 sm:mx-4 px-4 sm:px-6">
		<slot />
	</main>

	<footer class="h-10 flex justify-center">
		<div class="flex place-items-center space-x-2">
			<p class="text-gray-500 text-sm">Copyright©2023 Lab 3 for Database Systems Principles and Security. All rights reserved.</p>
		</div>
	</footer>
</div>
