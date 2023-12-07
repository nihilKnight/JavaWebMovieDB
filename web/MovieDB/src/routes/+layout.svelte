<script>
  import '../app.css';
  import Header from '../lib/layouts/Header.svelte';
</script>

<div class="page-container">
	<Header />

	<main class="main-content">
		<slot />
	</main>

	<footer class="footer">
		<div class="footline">
			<p class="text-gray-500 text-sm">Copyright©2023 Lab 3 for Database Systems Principles and Security. All rights reserved.</p>
		</div>
	</footer>
</div>

<style>
	.main-content {
		padding: 1rem;
	}

	.footline{
		text-align: center; /* 文本居中 */
		font-size: 12px; /* 字体比其他小一号 */
		color: #888; /* 灰色字体颜色 */
		bottom: 0;
		left: 0;
		width: 100%;
		padding: 10px; /* 底部的内边距 */
	}
</style>