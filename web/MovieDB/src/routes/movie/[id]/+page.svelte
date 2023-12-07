<script>
  import { page } from '$app/stores'
	import { onMount } from 'svelte'
  import { API, KEY } from '../../../lib/api'

  const id = $page.url.pathname.split('/')[2]

  let movie

  async function load() {
    movie = await fetch(
			`${API}/movie/${id}${KEY}&language=en-US`
		).then(res => res.json())
  }

  onMount(() => load())

  function getYearFromDate(dateString) {
    const date = new Date(dateString);
    return date.getFullYear();
  }
</script>

<!-- 标题设置 -->
<svelte:head>
	<title>{movie ? movie.title : 'Movie'} - MovieDB</title>
</svelte:head>

{#if movie}
  <section class="movie-section">
    <div class="movie-poster">
      <img src={`https://image.tmdb.org/t/p/original${movie.backdrop_path}`} alt="Poster">
    </div>
    
    <div class="movie-info">
      <h2 class="movie-title">
        {movie.title}
        <span class="movie-rating">&#9733;{movie.vote_average.toFixed(1)}</span>
      </h2>
      <p class="movie-overview">{movie.overview}</p>
    </div>

    <div class="movie-details">
      <table class="table-fixed">
        <tbody class="text-left">
          <tr class="border-b-8">
            <th>Companies</th>
            <td>{ movie.production_companies.map(item => item.name).join(', ') }</td>
          </tr>

          <tr class="border-y-8">
            <th>Countries</th>
            <td>{ movie.production_countries.map(item => item.name).join(', ') }</td>
          </tr>

          <tr class="border-y-8">
            <th>Spoken Languages</th>
            <td>{ movie.spoken_languages?.map(item => item.name).join(', ') }</td>
          </tr>

          <tr class="border-y-8">
            <th>Genres</th>
            <td>{ movie.genres.map(item => item.name).join(', ') }</td>
          </tr>

          <tr class="border-y-8">
            <th>Release Date</th>
            <td>{movie.release_date}</td>
          </tr>
          
          <tr class="border-y-8">
            <th>Runtime</th>
            <td>{movie.runtime} minutes</td>
          </tr>

          <tr class="border-y-8">
            <th>Budget</th>
            <td>R${movie.budget.toFixed(2)}</td>
          </tr>

          <tr class="border-y-8">
            <th>Revenue</th>
            <td>R${movie.revenue.toFixed(2)}</td>
          </tr>

          <tr class="border-t-8">
            <th>Vote Count</th>
            <td>{movie.vote_count}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>
{:else}
  <h2 class="loading-message">Loading...</h2>
{/if}

<style>
  .movie-poster {
    order: 1;
    width: 40%;
    margin: auto; /* 将图像容器水平居中 */
    border-radius: 1rem;
    overflow: hidden;
  }

  .movie-poster img {
    width: 100%;
    border-radius: 1rem;
  }

  .movie-info {
    order: 2;
  }

  .movie-details {
    order: 3;
  }

  .movie-title {
    font-size: 1.875rem; /* 对应 text-3xl */
    font-weight: 600; /* 对应 font-semibold */
    color: rgba(59, 130, 246, 0.8); /* 对应 text-blue-500/80 */
    margin-bottom: 1rem; /* 对应 my-4 */
  }

  .movie-rating {
    color: #ffd700; /* 对应 text-yellow-500 */
    font-size: 1.125rem; /* 对应 text-2xl */
    margin-left: 0.5rem; 
  }

  .movie-overview {
    margin-top: 1rem; 
    margin-bottom: 1rem; 
  }

  .table-fixed {
    width: 100%;
    border-collapse: collapse;
    margin-top: 1rem; 
  }

  .table-fixed th,
  .table-fixed td {
    border: 2px solid #e5e5e5; 
    padding: 0.5rem; 
  }

  .table-fixed th {
    width: 8rem; 
  }

  .table-fixed tr:nth-child(even) {
    background-color: #f9f9f9; 
  }

  .table-fixed tr.border-b-8 {
    border-bottom: 8px solid transparent; 
  }

  .table-fixed tr.border-y-8 {
    border-top: 8px solid transparent; 
    border-bottom: 8px solid transparent; 
  }

  .table-fixed tr.border-t-8 {
    border-top: 8px solid transparent; 
  }

  .loading-message {
    margin: 0 auto; /* 对应 m-auto */
    font-size: 1.5rem; /* 对应 text-2xl */
  }
</style>



