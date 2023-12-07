<script>
  { /* 导入 */ }
  {/*onMount用于处理生命周期*/}
	import { onMount } from 'svelte' 
  import { API, KEY } from '../lib/api'
  import MovieCard from '../lib/components/MovieCard.svelte'
  
  { /* 初始化 */ }
  let popularMovies
  let media = 'movie'
  let time = 'week'
  { /* 异步数据获取 */ }
  async function load() {
    const data = await fetch(
			`${API}/trending/${media}/${time}${KEY}&page=1&language=en-US`
		).then(res => res.json())
    popularMovies = data.results
  }
  
  {/*onMount在组件挂载时调用load*/}
  onMount(() => load())
</script>

<svelte:head>
	<title>PopularMovies - MovieDB</title>
</svelte:head>

<!-- 条件渲染 -->
<h3>Popular Movies</h3>
<div class="trending-container">
  {#if popularMovies}
    <div class="grid-container">
      {#each popularMovies as show (show.id)}
        <MovieCard item={show} />
      {/each}
    </div>
  {:else} 
    <h2 class="loading-text">Loading...</h2>
  {/if}
</div>

<style>
  h2{
      padding: 0 1rem;
  }
  h3{
      padding: 0 1rem;
  }

  .trending-container {
  margin-bottom: 1.5rem;
}

  .grid-container {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 1rem;
  }

  @media (min-width: 640px) {
    .grid-container {
      grid-template-columns: repeat(4, minmax(0, 1fr));
    }
  }

  @media (min-width: 1024px) {
    .grid-container {
      grid-template-columns: repeat(6, minmax(0, 1fr));
    }
  }

  .loading-text {
    margin: auto;
    font-size: 1.5rem;
  }
</style>